package org.gesis.persistence.relational;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.gesis.discovery.Study;
import org.gesis.discovery.Variable;
import org.gesis.discovery.persistence.StudyDAO;
import org.gesis.discovery.persistence.VariableDAO;
import org.gesis.persistence.PersistenceStrategy;
import org.gesis.rdf.LangString;
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

	private VariableDAO variableDAO;

	@Before
	public void init()
	{
		studyDAO = persistenceStrategy.getStudyDAO();
		assertNotNull( studyDAO );

		variableDAO = persistenceStrategy.getVariableDAO();
		assertNotNull( variableDAO );
	}

	@Test
	@Transactional
	public void insert()
	{
		// create Study
		final Study study = new Study();
		study.setTitle( LangString.uk( "new uk title" ) );
		study.setAbstract( LangString.de( "new de abstract" ) );
		study.setURN( "agencyId:study:version" );

		// create Variable
		Variable variable = new Variable();
		variable.setURN( "agencyId:variable:version" );

		study.addVariable( variable );

		studyDAO.persist( study );

		// get persisted Study
		Study persistedStudy = studyDAO.getByURN( "agencyId:study:version" );

		assertNotNull( persistedStudy );
		assertNotNull( persistedStudy.getTitle() );
		assertEquals( "new uk title", persistedStudy.getTitle().getEn() );

		assertNotNull( persistedStudy.getVariable() );
		assertEquals( 1, persistedStudy.getVariable().size() );

		studyDAO.delete( persistedStudy );

		persistedStudy = studyDAO.getByURN( "agencyId:study:version" );
		assertNull( persistedStudy );
	}

	@Test
	@Transactional
	public void getAll()
	{
		final List<Study> all = studyDAO.getAll();

		assertNotNull( all );
		assertEquals( 2, all.size() );
	}

	@Test
	@Transactional
	public void getById()
	{
		final Study persistedStudy = studyDAO.getById( "study1" );

		assertNotNull( persistedStudy );
		assertNotNull( persistedStudy.getTitle() );
		assertEquals( "Study 1", persistedStudy.getTitle().getEn() );
	}

	@Test
	@Transactional
	public void getByURN()
	{
		final Study persistedStudy = studyDAO.getByURN( "de.gesis:study1:0.1" );

		assertNotNull( persistedStudy );
		assertEquals( "Study 1", persistedStudy.getTitle().getEn() );
	}

	@Test
	public void getByTitle()
	{
		Study study = studyDAO.getByTitle( "Study 1", "2009" );
		assertNotNull( study );

		// does not exist
		study = studyDAO.getByTitle( "Study xy", "2018" );
		assertNull( study );
	}
}
