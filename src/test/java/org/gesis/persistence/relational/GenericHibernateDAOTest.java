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
		this.dao = this.persistenceStrategy.getStudyDAO();
		assertNotNull( this.dao );

		this.study = new Study();
		this.study.setDcterms_title( LangString.createUKLangString( "new uk title" ) );
		this.study.setURN( "agencyId:objectId:version" );

		this.dao.persist( this.study );
	}

	@After
	public void deleteStudies()
	{
		if ( this.study != null )
			this.dao.delete( this.study );
	}

	@Test
	@Transactional
	public void getAll()
	{
		List<Study> all = this.dao.getAll();
		assertNotNull( all );
		assertEquals( 1, all.size() );

		Study persistedStudy = all.get( 0 );
		assertNotNull( persistedStudy );
		assertEquals( "new uk title", persistedStudy.getDcterms_title().getEn() );
	}

	@Test
	@Transactional
	public void getById()
	{
		Study persistedStudy = this.dao.getById( this.study.getId(), false );
		assertNotNull( persistedStudy );
		assertEquals( this.study.getDcterms_title().getEn(), persistedStudy.getDcterms_title().getEn() );
	}

	@Test
	@Transactional
	public void getByURN()
	{
		Study persistedStudy = (Study) this.dao.getByURN( "agencyId:objectId:version" );
		assertNotNull( persistedStudy );
		assertEquals( "new uk title", persistedStudy.getDcterms_title().getEn() );
	}
}
