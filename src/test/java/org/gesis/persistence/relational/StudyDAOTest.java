package org.gesis.persistence.relational;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.gesis.discovery.Study;
import org.gesis.discovery.Variable;
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
@ContextConfiguration( locations = { "classpath:context-persistence-test-inMemoryDB.xml" } )
@TransactionConfiguration
public class StudyDAOTest
{
	@Autowired
	protected PersistenceStrategy persistenceStrategy;

	private StudyDAO studyDAO;
	private Study study;

	@Before
	public void init()
	{
		studyDAO = persistenceStrategy.getStudyDAO();
		assertNotNull( studyDAO );

		study = new Study();
		study.setTitle( LangString.createUKLangString( "new uk title" ) );
		study.setAbstract( LangString.createDELangString( "new de abstract" ) );
		study.setURN( "agencyId:study:version" );

		Variable variable = new Variable();
		variable.setURN( "agencyId:variable:version" );

		study.addVariable( variable );

		studyDAO.persist( study );
	}

	@After
	public void deleteStudies()
	{
		if ( study != null )
			studyDAO.delete( study );
	}

	@Test
	@Transactional
	public void getAll()
	{
		final List<Study> all = studyDAO.getAll();
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
		final Study persistedStudy = studyDAO.getById( study.getId(), false );
		assertNotNull( persistedStudy );
		assertEquals( study.getTitle().getEn(), persistedStudy.getTitle().getEn() );
	}

	@Test
	@Transactional
	public void getByURN()
	{
		final Study persistedStudy = studyDAO.getByURN( Study.class, "agencyId:study:version" );
		assertNotNull( persistedStudy );
		assertEquals( "new uk title", persistedStudy.getTitle().getEn() );
		assertEquals( "new de abstract", persistedStudy.getAbstract().getDe() );
	}

	@Test
	public void getVariableByURN()
	{
		final Variable persistedVariable = studyDAO.getByURN( Variable.class, "agencyId:variable:version" );
		assertNotNull( persistedVariable );
	}
}
