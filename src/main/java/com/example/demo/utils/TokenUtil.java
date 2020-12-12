package com.example.demo.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.demo.configs.Audience;
import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.Base64Codec;
import org.apache.logging.log4j.util.Base64Util;
import org.springframework.util.Base64Utils;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

public class TokenUtil {
    public static final String AUTH_HEADER_KEY = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";

    /**
     * 构建jwt
     * @param userId
     * @param audience
     * @return
     */
    public static String createJWT(String userId) throws Exception {
        try {
            String token = JWT.create().withAudience(userId)
                    .sign(Algorithm.HMAC256("alskjdfhalksdjfhauiodsyrfewr"));// 以 password 作为 token 的密钥
            return token;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("签名失败");
        }
    }

}
