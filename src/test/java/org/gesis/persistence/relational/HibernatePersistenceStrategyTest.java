package org.gesis.persistence.relational;

import static org.junit.Assert.assertNotNull;

import org.gesis.discovery.persistence.AnalysisUnitDAO;
import org.gesis.discovery.persistence.CategoryStatisticsDAO;
import org.gesis.discovery.persistence.DataFileDAO;
import org.gesis.discovery.persistence.DescriptiveStatisticsDAO;
import org.gesis.discovery.persistence.InstrumentDAO;
import org.gesis.discovery.persistence.LogicalDataSetDAO;
import org.gesis.discovery.persistence.PeriodOfTimeDAO;
import org.gesis.discovery.persistence.QuestionDAO;
import org.gesis.discovery.persistence.QuestionnaireDAO;
import org.gesis.discovery.persistence.RepresentationDAO;
import org.gesis.discovery.persistence.StudyDAO;
import org.gesis.discovery.persistence.StudyGroupDAO;
import org.gesis.discovery.persistence.SummaryStatisticsDAO;
import org.gesis.discovery.persistence.UniverseDAO;
import org.gesis.discovery.persistence.VariableDAO;
import org.gesis.discovery.persistence.RepresentedVariableDAO;
import org.gesis.persistence.PersistenceStrategy;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( locations = { "classpath:context-persistence-test-inMemoryDB.xml" } )
public class HibernatePersistenceStrategyTest
{

	@Autowired
	private PersistenceStrategy persistenceStrategy;

	@Before
	public void init()
	{
		assertNotNull( persistenceStrategy );
	}

	@Test
	public void notNullDAOsViaGetDAOMethod()
	{
		assertNotNull( persistenceStrategy.getDAO( AnalysisUnitDAO.class ) );
		assertNotNull( persistenceStrategy.getDAO( CategoryStatisticsDAO.class ) );
		assertNotNull( persistenceStrategy.getDAO( DataFileDAO.class ) );
		assertNotNull( persistenceStrategy.getDAO( DescriptiveStatisticsDAO.class ) );
		assertNotNull( persistenceStrategy.getDAO( InstrumentDAO.class ) );
		assertNotNull( persistenceStrategy.getDAO( LogicalDataSetDAO.class ) );
		assertNotNull( persistenceStrategy.getDAO( PeriodOfTimeDAO.class ) );
		assertNotNull( persistenceStrategy.getDAO( QuestionDAO.class ) );
		assertNotNull( persistenceStrategy.getDAO( QuestionnaireDAO.class ) );
		assertNotNull( persistenceStrategy.getDAO( RepresentationDAO.class ) );
		assertNotNull( persistenceStrategy.getDAO( StudyDAO.class ) );
		assertNotNull( persistenceStrategy.getDAO( StudyGroupDAO.class ) );
		assertNotNull( persistenceStrategy.getDAO( SummaryStatisticsDAO.class ) );
		assertNotNull( persistenceStrategy.getDAO( UniverseDAO.class ) );
		assertNotNull( persistenceStrategy.getDAO( VariableDAO.class ) );
		assertNotNull( persistenceStrategy.getDAO( RepresentedVariableDAO.class ) );
	}

	@Test
	public void notNullDAOsViaGetXDAOMethod()
	{
		assertNotNull( persistenceStrategy.getAnalysisUnitDAO() );
		assertNotNull( persistenceStrategy.getCategoryStatisticsDAO() );
		assertNotNull( persistenceStrategy.getDataFileDAO() );
		assertNotNull( persistenceStrategy.getDescriptiveStatisticsDAO() );
		assertNotNull( persistenceStrategy.getInstrumentDAO() );
		assertNotNull( persistenceStrategy.getLogicalDataSetDAO() );
		assertNotNull( persistenceStrategy.getPeriodOfTimeDAO() );
		assertNotNull( persistenceStrategy.getQuestionDAO() );
		assertNotNull( persistenceStrategy.getQuestionnaireDAO() );
		assertNotNull( persistenceStrategy.getRepresentationDAO() );
		assertNotNull( persistenceStrategy.getStudyDAO() );
		assertNotNull( persistenceStrategy.getStudyGroupDAO() );
		assertNotNull( persistenceStrategy.getSummaryStatisticsDAO() );
		assertNotNull( persistenceStrategy.getUniverseDAO() );
		assertNotNull( persistenceStrategy.getVariableDAO() );
		assertNotNull( persistenceStrategy.getRepresentedVariableDAO() );
	}

}
