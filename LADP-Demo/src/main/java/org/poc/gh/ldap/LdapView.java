package org.poc.gh.ldap;

import java.util.List;

import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.ldap.filter.AndFilter;
import org.springframework.ldap.filter.EqualsFilter;

public class LdapView 
{

	@SuppressWarnings("unchecked")
	public static void main(String[] args)
	{
		String url="ldap://ldap.forumsys.com:389";
		String base="dc=example,dc=com";
		String userDn="cn=read-only-admin,dc=example,dc=com";
		String password="password";
		try
		{
			LdapContextSource ldapContext=new LdapContextSource();
			ldapContext.setUrl(url);
			ldapContext.setBase(base);
			ldapContext.setUserDn(userDn);
			ldapContext.setPassword(password);
			ldapContext.afterPropertiesSet();
			LdapTemplate ldapTemplate=new LdapTemplate(ldapContext);
			
		          /**  GET USERS **/
			AndFilter filter=new AndFilter();
			filter.and(new EqualsFilter("objectclass", "Person"));
			List<String> list=ldapTemplate.search("", filter.encode(),new ContactAttributeMapperJson());
			System.out.println(list.toString());
			  
			    /** GET GROUPS **/
			/* list=ldapTemplate.search("", "(&(objectclass=group)(objectclass=groupOfNames)(member=ui"
					 +"newton"+",ou=People,dc=example,dc=com))",new GroupContextMapperJSON());
			 //System.out.println(list.toString());
*/			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
