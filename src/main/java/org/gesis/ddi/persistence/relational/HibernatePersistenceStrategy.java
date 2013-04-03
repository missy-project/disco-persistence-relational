package org.gesis.ddi.persistence.relational;

import org.gesis.ddi.persistence.PersistenceStrategy;
import org.gesis.ddi.persistence.dataAccess.ConceptDAO;
import org.gesis.ddi.persistence.dataAccess.DataFileDAO;
import org.gesis.ddi.persistence.dataAccess.IdentifiableDAO;
import org.gesis.ddi.persistence.dataAccess.InstrumentDAO;
import org.gesis.ddi.persistence.dataAccess.LogicalDataSetDAO;
import org.gesis.ddi.persistence.dataAccess.QuestionDAO;
import org.gesis.ddi.persistence.dataAccess.QuestionnaireDAO;
import org.gesis.ddi.persistence.dataAccess.StudyDAO;
import org.gesis.ddi.persistence.dataAccess.UniverseDAO;
import org.gesis.ddi.persistence.dataAccess.VariableDAO;
import org.gesis.ddi.persistence.dataAccess.VariableDefinitionDAO;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class HibernatePersistenceStrategy implements PersistenceStrategy {

	private HibernateTemplate hibernateTemplate;

	private final String peristenceStrategyPostfix = "Hibernate";

	private ConceptDAO conceptDAO;
	private DataFileDAO dataFileDAO;
	private VariableDefinitionDAO dataElementDAO;
	private IdentifiableDAO identifiableDAO;
	private InstrumentDAO instrumentDAO;
	private LogicalDataSetDAO logicalDataSetDAO;
	private QuestionnaireDAO questionnaireDAO;
	private QuestionDAO questionDAO;
	private StudyDAO studyDAO;
	private UniverseDAO universeDAO;
	private VariableDAO variableDAO;

	// is going to be injected
	public void setSessionFactory( SessionFactory sessionFactory )
	{
		hibernateTemplate = new HibernateTemplate( sessionFactory );
	}

	@Override
	public <T> T getDAO( Class<T> daoClass )
	{
		try
		{
			if ( daoClass == null )
				return null;

			T genericDAO = daoClass.newInstance();

			return genericDAO;
		} catch (InstantiationException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	public VariableDAO getVariableDAO()
	{
		if ( variableDAO == null )
			variableDAO = new VariableDAOHibernate( hibernateTemplate );

		return variableDAO;
	}

	public void setVariableDAO( VariableDAO variableDAO )
	{
		this.variableDAO = variableDAO;
	}

	@Override
	public QuestionDAO getQuestionDAO()
	{
		if ( questionDAO == null )
			questionDAO = new QuestionDAOHibernate( hibernateTemplate );

		return questionDAO;
	}

	public void setQuestionDAO( QuestionDAO questionDAO )
	{
		this.questionDAO = questionDAO;
	}

	@Override
	public DataFileDAO getDataFileDAO()
	{
		if ( dataFileDAO == null )
			dataFileDAO = new DataFileDAOHibernate( hibernateTemplate );

		return dataFileDAO;
	}

	public void setDataFileDAO( DataFileDAO dataFileDAO )
	{
		this.dataFileDAO = dataFileDAO;
	}

	public QuestionnaireDAO getQuestionnaireDAO()
	{
		if ( questionnaireDAO == null )
			questionnaireDAO = new QuestionnaireDAOHibernate( hibernateTemplate );

		return questionnaireDAO;
	}

	public void setQuestionnaireDAO( QuestionnaireDAO questionnaireDAO )
	{
		this.questionnaireDAO = questionnaireDAO;
	}

	@Override
	public LogicalDataSetDAO getLogicalDataSetDAO()
	{
		if ( logicalDataSetDAO == null )
			logicalDataSetDAO = new LogicalDataSetDAOHibernate( hibernateTemplate );

		return logicalDataSetDAO;
	}

	public void setLogicalDataSetDAO( LogicalDataSetDAO logicalDataSetDAO )
	{
		this.logicalDataSetDAO = logicalDataSetDAO;
	}

	@Override
	public StudyDAO getStudyDAO()
	{
		if ( studyDAO == null )
			studyDAO = new StudyHibernateDAO( hibernateTemplate );

		return studyDAO;
	}

	public void setStudyDAO( StudyDAO studyDAO )
	{
		this.studyDAO = studyDAO;
	}

	@Override
	public IdentifiableDAO getIdentifiableDAO()
	{
		if ( identifiableDAO == null )
			identifiableDAO = new IdentifiableDAOHibernate( hibernateTemplate );

		return identifiableDAO;
	}

	public void setIdentifiableDAO( IdentifiableDAO identifiableDAO )
	{
		this.identifiableDAO = identifiableDAO;
	}

	@Override
	public ConceptDAO getConceptDAO()
	{
		if ( conceptDAO == null )
			conceptDAO = new ConceptDAOHibernate( hibernateTemplate );

		return conceptDAO;
	}

	public void setConceptDAO( ConceptDAO conceptDAO )
	{
		this.conceptDAO = conceptDAO;
	}

	@Override
	public VariableDefinitionDAO getDataElementDAO()
	{
		if ( dataElementDAO == null )
			dataElementDAO = new DataElementDAOHibernate( hibernateTemplate );

		return dataElementDAO;
	}

	public void setDataElementDAO( VariableDefinitionDAO dataElementDAO )
	{
		this.dataElementDAO = dataElementDAO;
	}

	@Override
	public InstrumentDAO getInstrumentDAO()
	{
		if ( instrumentDAO == null )
			instrumentDAO = new InstrumentDAOHibernate( hibernateTemplate );

		return instrumentDAO;
	}

	public void setInstrumentDAO( InstrumentDAO instrumentDAO )
	{
		this.instrumentDAO = instrumentDAO;
	}

	@Override
	public UniverseDAO getUniverseDAO()
	{
		if ( universeDAO == null )
			universeDAO = new UniverseDAOHibernate( hibernateTemplate );

		return universeDAO;
	}

	public void setUniverseDAO( UniverseDAO universeDAO )
	{
		this.universeDAO = universeDAO;
	}

}