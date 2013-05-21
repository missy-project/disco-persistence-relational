package org.gesis.ddi.persistence.relational;

import org.gesis.ddi.ontology.StudyGroup;
import org.gesis.ddi.persistence.dataAccess.StudyGroupDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class StudyGroupDAOHibernate extends GenericHibernateDAO<StudyGroup> implements StudyGroupDAO
{

	public StudyGroupDAOHibernate( HibernateTemplate hibernateTemplate )
	{
		super( hibernateTemplate );
	}

}
