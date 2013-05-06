package org.gesis.ddi.persistence.relational;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

import org.gesis.ddi.persistence.dataAccess.GenericDAO;
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
 */
public abstract class GenericHibernateDAO<T> implements GenericDAO<T>
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

	/**
	 * The hibernate template used by this class.
	 * 
	 * @return
	 */
	public HibernateTemplate getHibernateTemplate()
	{
		return this.hibernateTemplate;
	}

	/**
	 * The current session. In most cases <i>null</i> will be returned, since
	 * the session is maintained by hibernate.
	 * 
	 * @return
	 */
	protected Session getCurrentSession()
	{
		return this.sessionFactory.getCurrentSession();
	}

	/**
	 * Returns the generic type parameter, with which this object has been
	 * instantiated.
	 * 
	 * @return
	 */
	public Class<T> getPersistenceClass()
	{
		return this.persistenceClass;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.gesis.ddi.persistence.dataAccess.GenericDAO#getById(java.lang.String,
	 * boolean)
	 */
	@Transactional
	public T getById( final String urn, final boolean lock )
	{
		T entity = getHibernateTemplate().get( getPersistenceClass(), urn, lock ? LockMode.READ : LockMode.NONE );
		return entity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.gesis.ddi.persistence.dataAccess.GenericDAO#getAll()
	 */
	@Transactional
	public abstract List<T> getAll();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.gesis.ddi.persistence.dataAccess.GenericDAO#getByExample(java.lang
	 * .Object, java.lang.String[])
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.gesis.ddi.persistence.dataAccess.GenericDAO#persist(java.lang.Object)
	 */
	@Transactional
	public T persist( final T entity )
	{
		getHibernateTemplate().saveOrUpdate( entity );
		return entity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.gesis.ddi.persistence.dataAccess.GenericDAO#delete(java.lang.Object)
	 */
	@Transactional
	public boolean delete( final T entity )
	{
		getHibernateTemplate().delete( entity );
		return true;
	}
}
