package info.thecodinglive.member.service;

import info.thecodinglive.member.model.RememberMeToken;
import info.thecodinglive.member.repository.RememberMeTokenRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;

import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
@Slf4j
public class RememberMeTokenService implements PersistentTokenRepository {

    @Autowired
    private RememberMeTokenRepository rememberMeTokenRepository;

    @Override
    public void createNewToken(PersistentRememberMeToken token) {
        RememberMeToken newToken = new RememberMeToken(token);
        this.rememberMeTokenRepository.save(newToken);
    }

    @Override
    public void updateToken(String series, String tokenValue, Date lastUsed) {
        RememberMeToken token = this.rememberMeTokenRepository.findBySeries(series);
        if (token != null){
            token.setToken(tokenValue);
            token.setLastUsed(lastUsed);
            this.rememberMeTokenRepository.save(token);
        }
    }

    @Override
    public PersistentRememberMeToken getTokenForSeries(String seriesId) {
        RememberMeToken token = this.rememberMeTokenRepository.findBySeries(seriesId);
        if(token != null){
            return new PersistentRememberMeToken(token.getToken(), token.getSeries(), token.getToken(), token.getLastUsed());
        }
        return null;
    }

    @Override
    public void removeUserTokens(String username) {
        List<RememberMeToken> tokens = this.rememberMeTokenRepository.findByUsername(username);
        if(tokens != null){
            this.rememberMeTokenRepository.delete(tokens);
        }

    }
}
