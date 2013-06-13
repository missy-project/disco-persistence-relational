package org.gesis.persistence.relational;

import org.gesis.ddi.ontology.persistence.AnalysisUnitDAO;
import org.gesis.ddi.ontology.persistence.CategoryStatisticsDAO;
import org.gesis.ddi.ontology.persistence.ConceptDAO;
import org.gesis.ddi.ontology.persistence.DataFileDAO;
import org.gesis.ddi.ontology.persistence.DescriptiveStatisticsDAO;
import org.gesis.ddi.ontology.persistence.InstrumentDAO;
import org.gesis.ddi.ontology.persistence.LogicalDataSetDAO;
import org.gesis.ddi.ontology.persistence.PeriodOfTimeDAO;
import org.gesis.ddi.ontology.persistence.QuestionDAO;
import org.gesis.ddi.ontology.persistence.QuestionnaireDAO;
import org.gesis.ddi.ontology.persistence.RepresentationDAO;
import org.gesis.ddi.ontology.persistence.StudyDAO;
import org.gesis.ddi.ontology.persistence.StudyGroupDAO;
import org.gesis.ddi.ontology.persistence.SummaryStatisticsDAO;
import org.gesis.ddi.ontology.persistence.UniverseDAO;
import org.gesis.ddi.ontology.persistence.VariableDAO;
import org.gesis.ddi.ontology.persistence.VariableDefinitionDAO;
import org.gesis.ddi.ontology.persistence.relational.AnalysisUnitDAOHibernate;
import org.gesis.ddi.ontology.persistence.relational.CategoryStatisticsDAOHibernate;
import org.gesis.ddi.ontology.persistence.relational.ConceptDAOHibernate;
import org.gesis.ddi.ontology.persistence.relational.DataFileDAOHibernate;
import org.gesis.ddi.ontology.persistence.relational.DescriptiveStatisticsDAOHibernate;
import org.gesis.ddi.ontology.persistence.relational.InstrumentDAOHibernate;
import org.gesis.ddi.ontology.persistence.relational.LogicalDataSetDAOHibernate;
import org.gesis.ddi.ontology.persistence.relational.PeriodOfTimeDAOHibernate;
import org.gesis.ddi.ontology.persistence.relational.QuestionDAOHibernate;
import org.gesis.ddi.ontology.persistence.relational.QuestionnaireDAOHibernate;
import org.gesis.ddi.ontology.persistence.relational.RepresentationDAOHibernate;
import org.gesis.ddi.ontology.persistence.relational.StudyGroupDAOHibernate;
import org.gesis.ddi.ontology.persistence.relational.StudyHibernateDAO;
import org.gesis.ddi.ontology.persistence.relational.SummaryStatisticsDAOHibernate;
import org.gesis.ddi.ontology.persistence.relational.UniverseDAOHibernate;
import org.gesis.ddi.ontology.persistence.relational.VariableDAOHibernate;
import org.gesis.ddi.ontology.persistence.relational.VariableDefinitionDAOHibernate;
import org.gesis.persistence.PersistenceStrategy;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class HibernatePersistenceStrategy implements PersistenceStrategy
{

	private HibernateTemplate hibernateTemplate;

	private final String peristenceStrategyPostfix = "Hibernate";

	private ConceptDAO conceptDAO;
	private DataFileDAO dataFileDAO;
	private VariableDefinitionDAO variableDefinitionDAO;
	private InstrumentDAO instrumentDAO;
	private LogicalDataSetDAO logicalDataSetDAO;
	private QuestionnaireDAO questionnaireDAO;
	private QuestionDAO questionDAO;
	private StudyDAO studyDAO;
	private UniverseDAO universeDAO;
	private VariableDAO variableDAO;
	private AnalysisUnitDAO analysisUnitDAO;
	private CategoryStatisticsDAO categoryStatisticsDAO;
	private DescriptiveStatisticsDAO descriptiveStatisticsDAO;
	private PeriodOfTimeDAO periodOfTimeDAO;
	private RepresentationDAO representationDAO;
	private StudyGroupDAO studyGroupDAO;
	private SummaryStatisticsDAO summaryStatisticsDAO;

	// is going to be injected
	public void setSessionFactory( final SessionFactory sessionFactory )
	{
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	@Override
	public <T> T getDAO( final Class<T> daoClass )
	{
		try
		{
			if (daoClass == null)
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

	@Override
	public VariableDAO getVariableDAO()
	{
		if (this.variableDAO == null)
			this.variableDAO = new VariableDAOHibernate(this.hibernateTemplate);

		return this.variableDAO;
	}

	public void setVariableDAO( final VariableDAO variableDAO )
	{
		this.variableDAO = variableDAO;
	}

	@Override
	public QuestionDAO getQuestionDAO()
	{
		if (this.questionDAO == null)
			this.questionDAO = new QuestionDAOHibernate(this.hibernateTemplate);

		return this.questionDAO;
	}

	public void setQuestionDAO( final QuestionDAO questionDAO )
	{
		this.questionDAO = questionDAO;
	}

	@Override
	public DataFileDAO getDataFileDAO()
	{
		if (this.dataFileDAO == null)
			this.dataFileDAO = new DataFileDAOHibernate(this.hibernateTemplate);

		return this.dataFileDAO;
	}

	public void setDataFileDAO( final DataFileDAO dataFileDAO )
	{
		this.dataFileDAO = dataFileDAO;
	}

	@Override
	public QuestionnaireDAO getQuestionnaireDAO()
	{
		if (this.questionnaireDAO == null)
			this.questionnaireDAO = new QuestionnaireDAOHibernate(
					this.hibernateTemplate);

		return this.questionnaireDAO;
	}

	public void setQuestionnaireDAO( final QuestionnaireDAO questionnaireDAO )
	{
		this.questionnaireDAO = questionnaireDAO;
	}

	@Override
	public LogicalDataSetDAO getLogicalDataSetDAO()
	{
		if (this.logicalDataSetDAO == null)
			this.logicalDataSetDAO = new LogicalDataSetDAOHibernate(
					this.hibernateTemplate);

		return this.logicalDataSetDAO;
	}

	public void setLogicalDataSetDAO( final LogicalDataSetDAO logicalDataSetDAO )
	{
		this.logicalDataSetDAO = logicalDataSetDAO;
	}

	@Override
	public StudyDAO getStudyDAO()
	{
		if (this.studyDAO == null)
			this.studyDAO = new StudyHibernateDAO(this.hibernateTemplate);

		return this.studyDAO;
	}

	public void setStudyDAO( final StudyDAO studyDAO )
	{
		this.studyDAO = studyDAO;
	}

	@Override
	public ConceptDAO getConceptDAO()
	{
		if (this.conceptDAO == null)
			this.conceptDAO = new ConceptDAOHibernate(this.hibernateTemplate);

		return this.conceptDAO;
	}

	public void setConceptDAO( final ConceptDAO conceptDAO )
	{
		this.conceptDAO = conceptDAO;
	}

	@Override
	public VariableDefinitionDAO getVariableDefinitionDAO()
	{
		if (this.variableDefinitionDAO == null)
			this.variableDefinitionDAO = new VariableDefinitionDAOHibernate(
					this.hibernateTemplate);

		return this.variableDefinitionDAO;
	}

	public void setDataElementDAO( final VariableDefinitionDAO dataElementDAO )
	{
		this.variableDefinitionDAO = dataElementDAO;
	}

	@Override
	public InstrumentDAO getInstrumentDAO()
	{
		if (this.instrumentDAO == null)
			this.instrumentDAO = new InstrumentDAOHibernate(
					this.hibernateTemplate);

		return this.instrumentDAO;
	}

	public void setInstrumentDAO( final InstrumentDAO instrumentDAO )
	{
		this.instrumentDAO = instrumentDAO;
	}

	@Override
	public UniverseDAO getUniverseDAO()
	{
		if (this.universeDAO == null)
			this.universeDAO = new UniverseDAOHibernate(this.hibernateTemplate);

		return this.universeDAO;
	}

	public void setUniverseDAO( final UniverseDAO universeDAO )
	{
		this.universeDAO = universeDAO;
	}

	@Override
	public AnalysisUnitDAO getAnalysisUnitDAO()
	{
		if (this.analysisUnitDAO == null)
			this.analysisUnitDAO = new AnalysisUnitDAOHibernate(
					this.hibernateTemplate);

		return this.analysisUnitDAO;
	}

	@Override
	public CategoryStatisticsDAO getCategoryStatisticsDAO()
	{
		if (this.categoryStatisticsDAO == null)
			this.categoryStatisticsDAO = new CategoryStatisticsDAOHibernate(
					this.hibernateTemplate);

		return this.categoryStatisticsDAO;
	}

	@Override
	public DescriptiveStatisticsDAO getDescriptiveStatisticsDAO()
	{
		if (this.descriptiveStatisticsDAO == null)
			this.descriptiveStatisticsDAO = new DescriptiveStatisticsDAOHibernate(
					this.hibernateTemplate);

		return this.descriptiveStatisticsDAO;
	}

	@Override
	public RepresentationDAO getRepresentationDAO()
	{
		if (this.representationDAO == null)
			this.representationDAO = new RepresentationDAOHibernate(
					this.hibernateTemplate);

		return this.representationDAO;
	}

	@Override
	public StudyGroupDAO getStudyGroupDAO()
	{
		if (this.studyGroupDAO == null)
			this.studyGroupDAO = new StudyGroupDAOHibernate(
					this.hibernateTemplate);

		return this.studyGroupDAO;
	}

	@Override
	public SummaryStatisticsDAO getSummaryStatisticsDAO()
	{
		if (this.summaryStatisticsDAO == null)
			this.summaryStatisticsDAO = new SummaryStatisticsDAOHibernate(
					this.hibernateTemplate);

		return this.summaryStatisticsDAO;
	}

	@Override
	public PeriodOfTimeDAO getPeriodOfTimeDAO()
	{
		if (this.periodOfTimeDAO == null)
			this.periodOfTimeDAO = new PeriodOfTimeDAOHibernate(
					this.hibernateTemplate);

		return this.periodOfTimeDAO;
	}

}
