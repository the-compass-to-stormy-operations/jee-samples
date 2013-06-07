package tirando.onda.jee.jaas;

import java.io.Serializable;
import java.security.Principal;
import java.security.acl.Group;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

public class SimpleGroup implements Group, Serializable {

  	private static final long serialVersionUID = 1L;
  	
  	private String name;
  	private Set<Principal> members;
  	
  	public SimpleGroup(String name) {
  		this.name = name;		
  		members = new HashSet<Principal>();
  	}
  
  	public String getName() {
  		return name;
  	}
  
  	public boolean addMember(Principal member) {
  		return members.add(member);
  	}
  
  	public boolean removeMember(Principal member) {
  		return members.remove(member);
  	}
  
  	public boolean isMember(Principal member) {
  		return members.contains(member);
  	}
  
  	public Enumeration<? extends Principal> members() {
  		return Collections.enumeration(members);
  	}

}
