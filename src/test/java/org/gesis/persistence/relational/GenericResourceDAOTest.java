package org.gesis.persistence.relational;

import static org.junit.Assert.assertNotNull;

import org.gesis.discovery.StudyGroup;
import org.gesis.persistence.PersistenceStrategy;
import org.gesis.rdf.LangString;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( locations = { "classpath:context-persistence-test-inMemoryDB.xml" } )
public class GenericResourceDAOTest
{

	@Autowired
	private PersistenceStrategy persistenceStrategy;

	@Test
	public void getByPrefLabel()
	{
		StudyGroup studyGroup = persistenceStrategy.getStudyGroupDAO().getByPrefLabel( LangString.uk( "prefLabel 1" ) );
		assertNotNull( studyGroup );
	}
}
