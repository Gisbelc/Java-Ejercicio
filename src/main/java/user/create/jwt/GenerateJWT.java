//package user.create.jwt;
//
//import java.util.Date;
//
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import user.create.model.User;
//
//public class GenerateJWT {
//	
//	
//    public String generateJwt() {
//    	
//        User user = new User();
//        int jwtMinute = 60;
//        String secretCode = "test";
//
//        String jwt = Jwts.builder()
//                .setSubject(user.getToken()) // Establece el sujeto del token
//                .setExpiration(new Date(System.currentTimeMillis() + jwtMinute * 60000)) // Fecha de expiración
//                .signWith(SignatureAlgorithm.HS512, secretCode) // Firma el token con el algoritmo HS512 y la clave secreta
//                .compact();
//
//        return jwt;
//    }
//
//}
