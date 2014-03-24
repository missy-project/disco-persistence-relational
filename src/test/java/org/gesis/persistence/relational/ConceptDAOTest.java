package org.gesis.persistence.relational;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.gesis.persistence.PersistenceStrategy;
import org.gesis.skos.Concept;
import org.gesis.skos.persistence.ConceptDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( locations = { "classpath:context-persistence-test-inMemoryDB.xml" } )
@TransactionConfiguration
public class ConceptDAOTest
{

	@Autowired
	private PersistenceStrategy persistenceStrategy;

	private ConceptDAO conceptDao;

	@Before
	public void init()
	{
		assertNotNull( persistenceStrategy );

		conceptDao = persistenceStrategy.getConceptDAO();

		assertNotNull( conceptDao );
	}

	@Test
	public void getByNotation_list()
	{
		List<Concept> concepts = conceptDao.getByNotation( "a notation" );
		assertNotNull( concepts );
		assertEquals( 2, concepts.size() );

		for ( Concept concept : concepts )
			assertNotNull(concept);
	}

	@Test
	public void getByNotation_one()
	{
		List<Concept> concept = conceptDao.getByNotation( "notation for concept3" );
		assertNotNull( concept );
		assertNotNull( concept.get( 0 ) );
	}
}
