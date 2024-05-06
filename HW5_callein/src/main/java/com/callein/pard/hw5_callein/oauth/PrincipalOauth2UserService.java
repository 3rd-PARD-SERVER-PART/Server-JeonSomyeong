package com.callein.pard.hw5_callein.oauth;

import com.callein.pard.hw5_callein.oauth.dto.OAuthAttributes;
import com.callein.pard.hw5_callein.oauth.dto.SessionUser;
import com.callein.pard.hw5_callein.user.entity.User;
import com.callein.pard.hw5_callein.user.repo.UserRepo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@Slf4j
@RequiredArgsConstructor
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {
    private final UserRepo userRepo;
    private final HttpSession httpSession;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest)
            throws OAuth2AuthenticationException {
        log.info("📍 google userRequest: "+oAuth2UserRequest );

        OAuth2User oAuth2User = super.loadUser(oAuth2UserRequest);
        log.info("📍 oauth : "+ oAuth2User.getAttributes());

        String registrationId = oAuth2UserRequest.getClientRegistration().getRegistrationId();
        String userNameAttributeName = oAuth2UserRequest.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();

        OAuthAttributes attributes = OAuthAttributes.of(registrationId, userNameAttributeName, oAuth2User.getAttributes());

        User user = saveOrUpdate(attributes);
        httpSession.setAttribute("user", new SessionUser(user));

        return super.loadUser(oAuth2UserRequest);
    }
    private User saveOrUpdate(OAuthAttributes attributes) {
        User user = userRepo.findByEmail(attributes.getEmail())
                .map(entity -> entity.update(attributes.getName()))
                .orElse(attributes.toEntity());

        return userRepo.save(user);
    }
}
