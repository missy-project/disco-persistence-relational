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

	private VariableDAO variableDAO;

	@Before
	public void init()
	{
		studyDAO = persistenceStrategy.getStudyDAO();
		assertNotNull( studyDAO );

		variableDAO = persistenceStrategy.getVariableDAO();
		assertNotNull( variableDAO );

		study = new Study();
		study.setTitle( LangString.uk( "new uk title" ) );
		study.setAbstract( LangString.de( "new de abstract" ) );
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
		final Study persistedStudy = studyDAO.getById( study.getId() );
		assertNotNull( persistedStudy );
		assertEquals( study.getTitle().getEn(), persistedStudy.getTitle().getEn() );
	}

	@Test
	@Transactional
	public void getByURN()
	{
		final Study persistedStudy = studyDAO.getByURN( "agencyId:study:version" );
		assertNotNull( persistedStudy );
		assertEquals( "new uk title", persistedStudy.getTitle().getEn() );
		assertEquals( "new de abstract", persistedStudy.getAbstract().getDe() );
	}

	@Test
	public void getVariableByURN()
	{
		final Variable persistedVariable = variableDAO.getByURN( "agencyId:variable:version" );
		assertNotNull( persistedVariable );
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
