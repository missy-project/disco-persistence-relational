package org.gesis.persistence.relational;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.gesis.discovery.Study;
import org.gesis.discovery.persistence.StudyDAO;
import org.gesis.persistence.PersistenceStrategy;
import org.gesis.rdf.LangString;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( locations = { "classpath:context-persistence-relational-test.xml" } )
@TransactionConfiguration
public class GenericHibernateDAOTest
{
	@Autowired
	protected PersistenceStrategy persistenceStrategy;

	private StudyDAO dao;
	private Study study;

	@Before
	public void init()
	{
		dao = persistenceStrategy.getStudyDAO();
		assertNotNull( dao );

		study = new Study();
		study.setTitle( LangString.createUKLangString( "new uk title" ) );
		study.setURN( "agencyId:objectId:version" );

		dao.persist( study );
	}

	@After
	public void deleteStudies()
	{
		if ( study != null )
			dao.delete( study );
	}

	@Test
	@Transactional
	public void getAll()
	{
		final List<Study> all = dao.getAll();
		assertNotNull( all );
		assertEquals( 1, all.size() );

		final Study persistedStudy = all.get( 0 );
		assertNotNull( persistedStudy );
		assertEquals( "new uk title", persistedStudy.getTitle().getEn() );
	}

	@Test
	@Transactional
	public void getById()
	{
		final Study persistedStudy = dao.getById( study.getId(), false );
		assertNotNull( persistedStudy );
		assertEquals( study.getTitle().getEn(), persistedStudy.getTitle().getEn() );
	}

	@Test
	@Transactional
	public void getByURN()
	{
		final Study persistedStudy = (Study) dao.getByURN( "agencyId:objectId:version" );
		assertNotNull( persistedStudy );
		assertEquals( "new uk title", persistedStudy.getTitle().getEn() );
	}
}
