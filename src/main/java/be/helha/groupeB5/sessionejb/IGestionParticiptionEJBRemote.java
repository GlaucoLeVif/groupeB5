package be.helha.groupeB5.sessionejb;

import java.util.List;

import javax.ejb.Remote;

import be.helha.groupeB5.entities.Membre;
import be.helha.groupeB5.entities.Participation;

@Remote
public interface IGestionParticiptionEJBRemote {
	List<Participation> selectAll();
	
	Participation addParticipation(Participation m);
	
	Participation deleteParticipation(Participation m);

}
