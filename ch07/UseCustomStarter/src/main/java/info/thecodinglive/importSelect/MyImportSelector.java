package info.thecodinglive.importSelect;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        AnnotationAttributes attr = AnnotationAttributes.fromMap(
                importingClassMetadata.getAnnotationAttributes(EnableAutoMyModule.class.getName(), false));
        String value = attr.getString("value");
        if ("someValue".equals(value)) {
            return new String[]{AConfig.class.getName()};
        } else {
            return new String[]{BConfig.class.getName()};
        }
    }
}
