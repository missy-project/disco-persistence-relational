package org.gesis.persistence.relational;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

import org.gesis.persistence.GenericDAO;
import org.gesis.persistence.PersistableResource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

	private static Logger log = LoggerFactory.getLogger( Class.class );

	/**
	 * Is going to be injected.
	 */
	@Autowired
	private SessionFactory sessionFactory = null;

	/**
	 * Is going to be injected.
	 */
	@Autowired( required = false )
	private HibernateTemplate hibernateTemplate = null;

	private Class<T> persistenceClass;

	/**
	 * Default constructor. Necessary in cases when this DAO-object is being
	 * created by a spring-context.
	 */
	@SuppressWarnings( "unchecked" )
	public GenericHibernateDAO()
	{
		if ( getClass().getGenericSuperclass() instanceof ParameterizedType )
			this.persistenceClass = (Class<T>) ( (ParameterizedType) getClass().getGenericSuperclass() ).getActualTypeArguments()[0];
		// in case we have more than one parent
		// TODO ZL rewrite. not the best solution, because not generic
		else if ( getClass().getSuperclass().getGenericSuperclass() instanceof ParameterizedType )
			this.persistenceClass = (Class<T>) ( (ParameterizedType) getClass().getSuperclass().getGenericSuperclass() ).getActualTypeArguments()[0];
		else
			this.persistenceClass = null;
	}

	/**
	 * Usually the specific DAO-class is instantiated by the spring-context. All
	 * required objects are then injected by spring. Use this constructor in
	 * case you want to instantiate the DAO-class manually.
	 * 
	 * @param hibernateTemplate
	 */
	@SuppressWarnings( "unchecked" )
	public GenericHibernateDAO( final HibernateTemplate hibernateTemplate )
	{
		if ( getClass().getGenericSuperclass() instanceof ParameterizedType )
			this.persistenceClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		else if ( getClass().getSuperclass().getGenericSuperclass() instanceof ParameterizedType )
			this.persistenceClass = (Class<T>) ((ParameterizedType) getClass().getSuperclass().getGenericSuperclass()).getActualTypeArguments()[0];
		else
			this.persistenceClass = null;

		// manually instantiated
		this.hibernateTemplate = hibernateTemplate;
		this.sessionFactory = hibernateTemplate.getSessionFactory();
	}

	// getter / setter

	/**
	 * The hibernate template used by this class.
	 * 
	 * @return
	 */
	public HibernateTemplate getHibernateTemplate()
	{
		return this.hibernateTemplate;
	}

	public void setHibernateTemplate( final HibernateTemplate hibernateTemplate )
	{
		this.hibernateTemplate = hibernateTemplate;
	}

	/**
	 * The session factory used by this class.
	 * 
	 * @return
	 */
	public SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}

	public void setSessionFactory( final SessionFactory sessionFactory )
	{
		this.sessionFactory = sessionFactory;
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

	// DAO methods

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.gesis.persistence.GenericDAO#getById(java.lang.String)
	 */
	@Override
	@Transactional
	public T getById( final String id )
	{
		T entity = getHibernateTemplate().get( getPersistenceClass(), id );
		return entity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.gesis.persistence.GenericDAO#getAll()
	 */
	@Override
	@Transactional
	public List<T> getAll()
	{
		List<T> allObjects = getHibernateTemplate().loadAll( getPersistenceClass() );

		if ( allObjects == null )
			return Collections.emptyList();

		return allObjects;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.gesis.persistence.GenericDAO#getByExample(java.lang.Object,
	 * java.lang.String[])
	 */
	@Override
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
	 * @see org.gesis.persistence.GenericDAO#persist(java.lang.Object)
	 */
	@Override
	@Transactional
	public T persist( final T entity )
	{
		if ( entity instanceof PersistableResource )
			log.debug( "Persisting entity with id:" + ((PersistableResource) entity).getId() + " urn:" + ((PersistableResource) entity).getURN() );

		getHibernateTemplate().saveOrUpdate( entity );
		return entity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.gesis.persistence.GenericDAO#delete(java.lang.Object)
	 */
	@Override
	@Transactional
	public boolean delete( final T entity )
	{
		getHibernateTemplate().delete( entity );
		return true;
	}
}
