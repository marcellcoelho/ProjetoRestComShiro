package br.com.projeto.servico.rest;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;

@Path("/login")
public class UserAccountRest {

	Realm realm = new JdbcRealm();
    DefaultSecurityManager sm = new DefaultSecurityManager(realm);

    @Path("success")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response userAuth(@FormParam("username") String username,
            @FormParam("password") String password) {
        Response r = null;
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        token.setRememberMe(true);
        SecurityUtils.setSecurityManager(sm);
        Subject currentUser = SecurityUtils.getSubject();

        try {
            currentUser.login(token);  
            r = Response.ok().entity(token).build();
        } catch (IncorrectCredentialsException ice) {
            System.out.println("Incorrect username/password!");
        }

        return r;
    }
    
}
