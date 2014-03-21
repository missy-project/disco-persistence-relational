package org.gesis.persistence.relational;

import java.util.HashMap;
import java.util.Map;

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
import org.gesis.discovery.persistence.relational.AnalysisUnitDAOHibernate;
import org.gesis.discovery.persistence.relational.CategoryStatisticsDAOHibernate;
import org.gesis.discovery.persistence.relational.DataFileDAOHibernate;
import org.gesis.discovery.persistence.relational.DescriptiveStatisticsDAOHibernate;
import org.gesis.discovery.persistence.relational.InstrumentDAOHibernate;
import org.gesis.discovery.persistence.relational.LogicalDataSetDAOHibernate;
import org.gesis.discovery.persistence.relational.PeriodOfTimeDAOHibernate;
import org.gesis.discovery.persistence.relational.QuestionDAOHibernate;
import org.gesis.discovery.persistence.relational.QuestionnaireDAOHibernate;
import org.gesis.discovery.persistence.relational.RepresentationDAOHibernate;
import org.gesis.discovery.persistence.relational.StudyDAOHibernate;
import org.gesis.discovery.persistence.relational.StudyGroupDAOHibernate;
import org.gesis.discovery.persistence.relational.SummaryStatisticsDAOHibernate;
import org.gesis.discovery.persistence.relational.UniverseDAOHibernate;
import org.gesis.discovery.persistence.relational.VariableDAOHibernate;
import org.gesis.discovery.persistence.relational.RepresentedVariableDAOHibernate;
import org.gesis.persistence.InstantiableDAO;
import org.gesis.persistence.PersistenceStrategy;
import org.gesis.rdf.persistence.ListDAO;
import org.gesis.rdf.persistence.relational.ListDAOHibernate;
import org.gesis.rdfs.persistence.ResourceDAO;
import org.gesis.rdfs.persistence.relational.ResourceDAOHibernate;
import org.gesis.skos.persistence.ConceptDAO;
import org.gesis.skos.persistence.ConceptSchemeDAO;
import org.gesis.skos.persistence.OrderedCollectionDAO;
import org.gesis.skos.persistence.relational.ConceptDAOHibernate;
import org.gesis.skos.persistence.relational.ConceptSchemeDAOHibernate;
import org.gesis.skos.persistence.relational.OrderedCollectionDAOHibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.BeanInstantiationException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * @author matthaeus
 * 
 */
public class HibernatePersistenceStrategy implements PersistenceStrategy
{

	private HibernateTemplate hibernateTemplate;

	@Autowired( required = false )
	private AnalysisUnitDAO analysisUnitDAO;

	@Autowired( required = false )
	private CategoryStatisticsDAO categoryStatisticsDAO;

	@Autowired( required = false )
	private ConceptDAO conceptDAO;

	@Autowired( required = false )
	private ConceptSchemeDAO conceptSchemeDAO;

	@Autowired( required = false )
	private DataFileDAO dataFileDAO;

	@Autowired( required = false )
	private DescriptiveStatisticsDAO descriptiveStatisticsDAO;

	@Autowired( required = false )
	private InstrumentDAO instrumentDAO;

	@Autowired( required = false )
	private ListDAO listDAO;

	@Autowired( required = false )
	private LogicalDataSetDAO logicalDataSetDAO;

	@Autowired( required = false )
	private OrderedCollectionDAO orderedCollectionDAO;

	@Autowired( required = false )
	private PeriodOfTimeDAO periodOfTimeDAO;

	@Autowired( required = false )
	private QuestionnaireDAO questionnaireDAO;

	@Autowired( required = false )
	private QuestionDAO questionDAO;

	@Autowired( required = false )
	private RepresentationDAO representationDAO;

	@Autowired( required = false )
	private ResourceDAO resourceDAO;

	@Autowired( required = false )
	private StudyGroupDAO studyGroupDAO;

	@Autowired( required = false )
	private StudyDAO studyDAO;

	@Autowired( required = false )
	private SummaryStatisticsDAO summaryStatisticsDAO;

	@Autowired( required = false )
	private UniverseDAO universeDAO;

	@Autowired( required = false )
	private VariableDAO variableDAO;

	@Autowired( required = false )
	private RepresentedVariableDAO variableDefinitionDAO;

	private final Map<String, InstantiableDAO> daoMap = new HashMap<String, InstantiableDAO>();

	public HibernatePersistenceStrategy()
	{
		daoMap.put( ConceptDAO.class.getName(), conceptDAO );
		daoMap.put( ConceptSchemeDAO.class.getName(), conceptSchemeDAO );
		daoMap.put( DataFileDAO.class.getName(), dataFileDAO );
		daoMap.put( RepresentedVariableDAO.class.getName(), variableDefinitionDAO );
		daoMap.put( InstrumentDAO.class.getName(), instrumentDAO );
		daoMap.put( ListDAO.class.getName(), listDAO );
		daoMap.put( LogicalDataSetDAO.class.getName(), logicalDataSetDAO );
		daoMap.put( QuestionnaireDAO.class.getName(), questionnaireDAO );
		daoMap.put( QuestionDAO.class.getName(), questionDAO );
		daoMap.put( StudyDAO.class.getName(), studyDAO );
		daoMap.put( UniverseDAO.class.getName(), universeDAO );
		daoMap.put( VariableDAO.class.getName(), variableDAO );
		daoMap.put( AnalysisUnitDAO.class.getName(), analysisUnitDAO );
		daoMap.put( CategoryStatisticsDAO.class.getName(), categoryStatisticsDAO );
		daoMap.put( DescriptiveStatisticsDAO.class.getName(), descriptiveStatisticsDAO );
		daoMap.put( OrderedCollectionDAO.class.getName(), orderedCollectionDAO );
		daoMap.put( PeriodOfTimeDAO.class.getName(), periodOfTimeDAO );
		daoMap.put( RepresentationDAO.class.getName(), representationDAO );
		daoMap.put( ResourceDAO.class.getName(), resourceDAO );
		daoMap.put( StudyGroupDAO.class.getName(), studyGroupDAO );
		daoMap.put( SummaryStatisticsDAO.class.getName(), summaryStatisticsDAO );
	}

	@Override
	public InstantiableDAO getDAO( final Class<?> clazz )
	{
		if ( clazz == null )
			return null;

		InstantiableDAO dao = daoMap.get( clazz.getName() );

		if ( dao != null )
			return dao;

		try
		{
			@SuppressWarnings( "static-access" )
			Class<?> namedClazz = getClass().forName( clazz.getPackage().getName() + ".relational." + clazz.getSimpleName() + "Hibernate" );

			Object instantiatedDao = BeanUtils.instantiateClass( namedClazz.getConstructor( HibernateTemplate.class ), this.hibernateTemplate );

			if ( !(instantiatedDao instanceof InstantiableDAO) )
				return null;

			return (InstantiableDAO) instantiatedDao;
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();

			return null;
		}
		catch (BeanInstantiationException e)
		{
			e.printStackTrace();
			return null;
		}
		catch (SecurityException e)
		{
			e.printStackTrace();
			return null;
		}
		catch (NoSuchMethodException e)
		{
			e.printStackTrace();
			return null;
		}

	}

	// is going to be injected
	public void setSessionFactory( final SessionFactory sessionFactory )
	{
		this.hibernateTemplate = new HibernateTemplate( sessionFactory );
	}

	/**
	 * Adds the given <i>dao</i>-object under the provided <i>name</i> to the
	 * map of all DAOs.
	 * 
	 * @param name
	 * @param dao
	 */
	@Override
	public void registerDAO( final String name, final InstantiableDAO dao )
	{
		if ( name == null || name.trim().equals( "" ) )
			return;

		if ( dao == null )
			return;

		this.daoMap.put( name, dao );
	}

	@Override
	public VariableDAO getVariableDAO()
	{
		if ( this.variableDAO == null )
			this.variableDAO = new VariableDAOHibernate( this.hibernateTemplate );

		return this.variableDAO;
	}

	public void setVariableDAO( final VariableDAO variableDAO )
	{
		this.variableDAO = variableDAO;
	}

	@Override
	public QuestionDAO getQuestionDAO()
	{
		if ( this.questionDAO == null )
			this.questionDAO = new QuestionDAOHibernate( this.hibernateTemplate );

		return this.questionDAO;
	}

	public void setQuestionDAO( final QuestionDAO questionDAO )
	{
		this.questionDAO = questionDAO;
	}

	@Override
	public DataFileDAO getDataFileDAO()
	{
		if ( this.dataFileDAO == null )
			this.dataFileDAO = new DataFileDAOHibernate( this.hibernateTemplate );

		return this.dataFileDAO;
	}

	public void setDataFileDAO( final DataFileDAO dataFileDAO )
	{
		this.dataFileDAO = dataFileDAO;
	}

	@Override
	public QuestionnaireDAO getQuestionnaireDAO()
	{
		if ( this.questionnaireDAO == null )
			this.questionnaireDAO = new QuestionnaireDAOHibernate( this.hibernateTemplate );

		return this.questionnaireDAO;
	}

	public void setQuestionnaireDAO( final QuestionnaireDAO questionnaireDAO )
	{
		this.questionnaireDAO = questionnaireDAO;
	}

	@Override
	public ListDAO getListDAO()
	{
		if ( this.listDAO == null )
			this.listDAO = new ListDAOHibernate( hibernateTemplate );

		return this.listDAO;
	}

	public void setListDAO( final ListDAO listDAO )
	{
		this.listDAO = listDAO;
	}

	@Override
	public LogicalDataSetDAO getLogicalDataSetDAO()
	{
		if ( this.logicalDataSetDAO == null )
			this.logicalDataSetDAO = new LogicalDataSetDAOHibernate( this.hibernateTemplate );

		return this.logicalDataSetDAO;
	}

	public void setLogicalDataSetDAO( final LogicalDataSetDAO logicalDataSetDAO )
	{
		this.logicalDataSetDAO = logicalDataSetDAO;
	}

	@Override
	public StudyDAO getStudyDAO()
	{
		if ( this.studyDAO == null )
			this.studyDAO = new StudyDAOHibernate( this.hibernateTemplate );

		return this.studyDAO;
	}

	public void setStudyDAO( final StudyDAO studyDAO )
	{
		this.studyDAO = studyDAO;
	}

	@Override
	public ConceptDAO getConceptDAO()
	{
		if ( this.conceptDAO == null )
			this.conceptDAO = new ConceptDAOHibernate( this.hibernateTemplate );

		return this.conceptDAO;
	}

	public void setConceptDAO( final ConceptDAO conceptDAO )
	{
		this.conceptDAO = conceptDAO;
	}

	@Override
	public RepresentedVariableDAO getVariableDefinitionDAO()
	{
		if ( this.variableDefinitionDAO == null )
			this.variableDefinitionDAO = new RepresentedVariableDAOHibernate( this.hibernateTemplate );

		return this.variableDefinitionDAO;
	}

	public void setDataElementDAO( final RepresentedVariableDAO dataElementDAO )
	{
		this.variableDefinitionDAO = dataElementDAO;
	}

	@Override
	public InstrumentDAO getInstrumentDAO()
	{
		if ( this.instrumentDAO == null )
			this.instrumentDAO = new InstrumentDAOHibernate( this.hibernateTemplate );

		return this.instrumentDAO;
	}

	public void setInstrumentDAO( final InstrumentDAO instrumentDAO )
	{
		this.instrumentDAO = instrumentDAO;
	}

	@Override
	public UniverseDAO getUniverseDAO()
	{
		if ( this.universeDAO == null )
			this.universeDAO = new UniverseDAOHibernate( this.hibernateTemplate );

		return this.universeDAO;
	}

	public void setUniverseDAO( final UniverseDAO universeDAO )
	{
		this.universeDAO = universeDAO;
	}

	@Override
	public AnalysisUnitDAO getAnalysisUnitDAO()
	{
		if ( this.analysisUnitDAO == null )
			this.analysisUnitDAO = new AnalysisUnitDAOHibernate( this.hibernateTemplate );

		return this.analysisUnitDAO;
	}

	@Override
	public CategoryStatisticsDAO getCategoryStatisticsDAO()
	{
		if ( this.categoryStatisticsDAO == null )
			this.categoryStatisticsDAO = new CategoryStatisticsDAOHibernate( this.hibernateTemplate );

		return this.categoryStatisticsDAO;
	}

	@Override
	public DescriptiveStatisticsDAO getDescriptiveStatisticsDAO()
	{
		if ( this.descriptiveStatisticsDAO == null )
			this.descriptiveStatisticsDAO = new DescriptiveStatisticsDAOHibernate( this.hibernateTemplate );

		return this.descriptiveStatisticsDAO;
	}

	@Override
	public RepresentationDAO getRepresentationDAO()
	{
		if ( this.representationDAO == null )
			this.representationDAO = new RepresentationDAOHibernate( this.hibernateTemplate );

		return this.representationDAO;
	}

	@Override
	public StudyGroupDAO getStudyGroupDAO()
	{
		if ( this.studyGroupDAO == null )
			this.studyGroupDAO = new StudyGroupDAOHibernate( this.hibernateTemplate );

		return this.studyGroupDAO;
	}

	@Override
	public SummaryStatisticsDAO getSummaryStatisticsDAO()
	{
		if ( this.summaryStatisticsDAO == null )
			this.summaryStatisticsDAO = new SummaryStatisticsDAOHibernate( this.hibernateTemplate );

		return this.summaryStatisticsDAO;
	}

	@Override
	public PeriodOfTimeDAO getPeriodOfTimeDAO()
	{
		if ( this.periodOfTimeDAO == null )
			this.periodOfTimeDAO = new PeriodOfTimeDAOHibernate( this.hibernateTemplate );

		return this.periodOfTimeDAO;
	}

	@Override
	public OrderedCollectionDAO getOrderedCollectionDAO()
	{
		if ( this.orderedCollectionDAO == null )
			this.orderedCollectionDAO = new OrderedCollectionDAOHibernate( this.hibernateTemplate );

		return this.orderedCollectionDAO;
	}

	@Override
	public ConceptSchemeDAO getConceptSchemeDAO()
	{
		if ( this.conceptSchemeDAO == null )
			this.conceptSchemeDAO = new ConceptSchemeDAOHibernate( this.hibernateTemplate );

		return this.conceptSchemeDAO;
	}

	@Override
	public ResourceDAO getResourceDAO()
	{
		if ( this.resourceDAO == null )
			this.resourceDAO = new ResourceDAOHibernate( this.hibernateTemplate );

		return this.resourceDAO;
	}

}
