package org.zs.forty.common.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.crypto.SecretKey;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * -*- coding: utf-8 -*-
 *
 * @Author: 子十
 * @Date: 2024/2/20
 * @Description: jwt工具类
 **/
@Slf4j
@Component
public class JwtUtil {
  // 密钥
  @Value("${jwt.secret}")
  private String SECRET;
  // 过期时间
  @Value("${jwt.expiration}")
  private long EXPIRE_TIME;
  @Value("${jwt.issuer}")
  private String JWT_ISS;
  private static final Long MILLIS_MINUTE_TEN = 20 * 60 * 1000L;
  
  /**
   * 创建JWT Token
   *
   * @param payload 载荷（Claims）
   * @return JWT Token
   */
  public String createToken(Map<String, Object> payload) {
    SecretKey key = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));
    String uuid = UUID.randomUUID().toString();
    io.jsonwebtoken.JwtBuilder builder = Jwts.builder()
        .setClaims(payload)
        .setIssuedAt(new Date())
        .setIssuer(JWT_ISS)
        .setId(uuid)
        .setExpiration(new Date(System.currentTimeMillis() + this.EXPIRE_TIME * 1000))
        .signWith(key, SignatureAlgorithm.HS256);
    return builder.compact();
  }
  
  /**
   * 解析JWT Token
   *
   * @param token JWT Token
   * @return 载荷（Claims）
   */
  public Map<String, Object> parseToken(String token) {
    SecretKey key = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));
    Map<String, Object> payload = new HashMap<>(
        parseClaims(token));
    payload.remove("exp");
    payload.remove("iat");
    payload.remove("iss");
    return payload;
  }
  
  /**
   * 验证JWT Token是否有效
   *
   * @param token JWT Token
   * @return 是否有效
   */
  public boolean validateToken(String token) {
    try {
      parseClaims(token);
      return true;
    } catch (Exception e) {
      return false;
    }
  }
  
  public boolean isTokenExpired(String token) {
    try {
      Claims claims = parseClaims(token);
      Date expiration = claims.getExpiration();
      return expiration.before(new Date());
    } catch (Exception e) {
      return true;
    }
  }
  
  /**
   * 解析JWT Token中的Claims
   *
   * @param token JWT Token
   * @return Claims
   */
  public Claims parseClaims(String token) {
    SecretKey key = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));
    return Jwts.parserBuilder()
        .setSigningKey(key)
        .build()
        .parseClaimsJws(token)
        .getBody();
  }
}