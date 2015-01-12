package org.gesis.dcterms.persistence.relational;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.gesis.dcterms.PeriodOfTime;
import org.gesis.dcterms.persistence.PeriodOfTimeDAO;
import org.gesis.persistence.PersistenceStrategy;
import org.joda.time.DateTime;
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
public class PeriodOfTimeDAOTest
{

	@Autowired
	protected PersistenceStrategy persistenceStrategy;

	private PeriodOfTimeDAO periodOfTimeDAO;

	@Before
	public void init()
	{
		periodOfTimeDAO = persistenceStrategy.getPeriodOfTimeDAO();
		assertNotNull( periodOfTimeDAO );
	}

	@Test
	public void getAll()
	{
		List<PeriodOfTime> periodOfTimes = periodOfTimeDAO.getAll();
		assertNotNull( periodOfTimes );
		assertEquals( 1, periodOfTimes.size() );
	}

	@Test
	public void getByStartDate()
	{
		PeriodOfTime byStartDate = periodOfTimeDAO.getByStartDate( DateTime.parse( "2009" ).toDate() );
		assertNotNull( byStartDate );
	}
}
