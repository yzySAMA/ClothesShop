package com.jack.service.impl;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jack.dao.UserMapper;
import com.jack.entity.User;
@Service
public class ShiroUserRealm extends AuthorizingRealm{

	@Autowired
	private UserMapper userMapper;
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}
	/**设置凭证匹配器*/
	@Override
	public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
		HashedCredentialsMatcher hCredential=new HashedCredentialsMatcher();
		hCredential.setHashAlgorithmName("MD5");
		super.setCredentialsMatcher(hCredential);
	}
	/**用户登录认证*/
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) 
			throws AuthenticationException {
		UsernamePasswordToken uToken=(UsernamePasswordToken)token;
		String username=uToken.getUsername();
		User user=userMapper.findByUsername(username);
		if(user==null)
			throw new UnknownAccountException();
		SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(user, user.getPassword(), 
				getName());
		return info;
	}
	
}
