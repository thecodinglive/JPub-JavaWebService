/**
 * CaptchaUtil.java 2017.11.23.
 * <p>
 * Copyright 2017 NAVER Corp. All rights Reserved.
 * NAVER PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package info.thecodinglive.util;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

public class CaptchaUtil {
    public static void writeImage(HttpServletResponse res, BufferedImage bi) {
        res.setHeader("Cache-Control", "private,no-cache,no-store");
        res.setContentType("image/png");

        try {
            writeImage(res.getOutputStream(), bi);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeImage(OutputStream os, BufferedImage bi) {
        try {
            ImageIO.write(bi, "png", os);
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
