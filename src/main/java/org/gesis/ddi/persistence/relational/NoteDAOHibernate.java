package org.gesis.ddi.persistence.relational;

import org.gesis.ddi.Note;
import org.gesis.ddi.persistence.dataAccess.NoteDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * @author matthaeus
 * 
 */
public class NoteDAOHibernate extends GenericHibernateDAO<Note> implements NoteDAO
{

	public NoteDAOHibernate( final HibernateTemplate hibernateTemplate )
	{
		super( hibernateTemplate );
	}

}
