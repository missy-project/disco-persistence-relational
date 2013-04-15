package org.gesis.ddi.persistence.relational;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

/**
 * This is an abstract class which defines some necessary attributes and methods
 * that will be used by all Data Access Object-classes implemented in the
 * Hibernate context.
 * 
 * @author matthaeus
 * 
 * @param <T>
 * @param <Id>
 */
public abstract class GenericHibernateDAO<T>
{

	/**
	 * Is going to be injected.
	 */
	private final SessionFactory sessionFactory;
	private final HibernateTemplate hibernateTemplate;
	
	private final Class<T> persistenceClass;

	private Session session;

	@SuppressWarnings( "unchecked" )
	public GenericHibernateDAO( final HibernateTemplate hibernateTemplate )
	{
		this.persistenceClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

		this.hibernateTemplate = hibernateTemplate;
		this.sessionFactory = hibernateTemplate.getSessionFactory();
	}

	public HibernateTemplate getHibernateTemplate()
	{
		return this.hibernateTemplate;
	}

	protected Session getCurrentSession()
	{
		return this.sessionFactory.getCurrentSession();
	}

	public Class<T> getPersistenceClass()
	{
		return this.persistenceClass;
	}

	@Transactional
	public T getById( final String urn, final boolean lock )
	{
		T entity = getHibernateTemplate().get( getPersistenceClass(), urn, lock ? LockMode.READ : LockMode.NONE );
		return entity;
	}

	@Transactional
	public abstract List<T> getAll();

	@Transactional
	public List<T> getByExample( final T exampleInstance, final String... excludeProperty )
	{
		Example example = Example.create( exampleInstance );

		if ( excludeProperty != null )
			for ( String property : excludeProperty )
				example.excludeProperty( property );

		DetachedCriteria criteria = DetachedCriteria.forClass( getPersistenceClass() );
		criteria.add( example );

		@SuppressWarnings( "unchecked" )
		List<T> list = getHibernateTemplate().findByCriteria( criteria );

		if ( list == null )
			return Collections.emptyList();

		return list;
	}

	@Transactional
	public T persist( final T entity )
	{
		getHibernateTemplate().saveOrUpdate( entity );
		return entity;
	}

	@Transactional
	public boolean delete( final T entity )
	{
		getHibernateTemplate().delete( entity );
		return true;
	}
}
