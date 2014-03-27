package org.gesis.persistence.relational;

import java.util.List;

import org.gesis.persistence.GenericResourceDAO;
import org.gesis.rdf.LangString;
import org.gesis.rdfs.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * This is an abstract class which defines some necessary attributes and methods
 * that will be used by all Data Access Object-classes implemented in the
 * Hibernate context.
 * 
 * @author matthaeus
 * 
 * @param <T>
 */
public abstract class GenericResourceHibernateDAO<T extends Resource> extends GenericHibernateDAO<T> implements GenericResourceDAO<T>
{

	public GenericResourceHibernateDAO( final HibernateTemplate hibernateTemplate )
	{
		super( hibernateTemplate );
	}

	private static Logger log = LoggerFactory.getLogger( Class.class );

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.gesis.ddi.persistence.dataAccess.GenericDAO#getByURN(java.lang.String)
	 */
	@Override
	@Transactional
	public T getByURN( final String urn )
	{
		if ( StringUtils.isEmpty( urn ) )
			return null;

		@SuppressWarnings( "unchecked" )
		List<T> list = getHibernateTemplate().find( "FROM " + getPersistenceClass().getName() + " WHERE urn=?", urn );

		if ( list == null || list.size() == 0 )
			return null;

		return list.get( 0 );
	}

	@Override
	public T getByPrefLabel( final LangString prefLabel )
	{
		if ( prefLabel == null )
			return null;

		if ( prefLabel.getDe() == null && prefLabel.getEn() == null && prefLabel.getFr() == null )
			return null;

		@SuppressWarnings( "unchecked" )
		List<T> list = getHibernateTemplate().find( "FROM " + getPersistenceClass().getName() + " c WHERE c.prefLabel.de = ? OR c.prefLabel.en = ? OR c.prefLabel.fr = ?", prefLabel.getDe(), prefLabel.getEn(), prefLabel.getFr() );

		if ( list == null || list.size() == 0 )
			return null;

		return list.get( 0 );
	}

}
