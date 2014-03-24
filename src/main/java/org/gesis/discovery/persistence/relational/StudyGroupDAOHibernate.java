package org.gesis.discovery.persistence.relational;

import org.gesis.discovery.StudyGroup;
import org.gesis.discovery.persistence.StudyGroupDAO;
import org.gesis.persistence.relational.GenericResourceHibernateDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * @author matthaeus
 * 
 */
public class StudyGroupDAOHibernate extends GenericResourceHibernateDAO<StudyGroup> implements StudyGroupDAO
{

	public StudyGroupDAOHibernate( final HibernateTemplate hibernateTemplate )
	{
		super( hibernateTemplate );
	}

}
