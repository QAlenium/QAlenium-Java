
package br.com.empresa.almintegration.constants;

public class ViewConstants {

	public static class GTEC {
		
		public static class Links {
			
			public static final String GTEC_URL_LOGIN = "gtec_url_login";
			public static final String GTEC_URL_PESQUISA = "gtec_url_pesquisa";
			
		}
		
		public static class Login {
			
			public static final String GTEC_USER = "gtec_user";
			public static final String GTEC_PASSWORD = "gtec_password";
			public static final String GTEC_DOMINIO = "gtec_dominio";
			
		}

		public static class Param {
			
			public static final String GTEC_PARAM_NUM_MAQUINETA = "gtec_param_num_maquineta";
			
		}
		
	}
	
	
	public static class DB {

		public static class ConfigTesteIntegrado {
			
			public static final String HOST = "host_ti";
			public static final String PORT = "port_ti";
			public static final String SID = "sid_ti";
			public static final String USERNAME = "username_ti";
			public static final String PASSWORD = "password_ti";
			
		}
		
		public static class ConfigHomologacao {
			
			public static final String HOST = "host_hml";
			public static final String PORT = "port_hml";
			public static final String SID = "sid_hml";
			public static final String USERNAME = "username_hml";
			public static final String PASSWORD = "password_hml";
			
		}
		
	}
	
	public static class ALM {

		public static class TestLab {
			
			public static final String RUNS = "runs";
			public static final String RUN_STEPS = "run-steps";
			public static final String TEST_INSTANCES = "test-instances";
			public static final String TEST_SETS = "test-sets";
			public static final String TEST_SET_FOLDER = "test-set-folders";
			public static final String TEST_PARAMETERS = "test-parameters";
			
		}

		public static class TestPlan {

			public static final String ASSETS_RELATIONS = "assets-relations";
			public static final String DELETED_ASSETS_INFOS = "deleted-assets-infos";
			public static final String DESIGN_STEPS = "design-steps";
			public static final String TEST = "tests";
			public static final String TEST_CONFIGS = "test-configs";
			public static final String TEST_CONFIGS_COVERAGES = "test-configs-coverages";
			public static final String TEST_FOLDERS = "test-folders";
			
		}

		public static class Requirements {

			public static final String REQUIREMENTS = "requirements";
			
		}

		public static class Resources {
			
			public static final String ASSETS_RELATIONS = "assets-relations";
			public static final String RESOURCES = "resources";
			public static final String RESOURCE_FOLDERS = "resource-folders";

		}

		public static class Releases {

			public static final String RELEASES = "releases";
			public static final String RELEASE_CYCLES = "release-cycles";
			public static final String RELEASE_FOLDERS = "release-folders";
			
		}

		public static class Favorites {

			public static final String FAVORITES = "favorites";
			public static final String FAVORITE_FOLDERS = "favorite-folders";
			
		}
		
		public static class Defects {

			public static final String DEFECTS = "defects";
			public static final String DEFECT_LINKS = "defect-links";

		}
		
		public static class Dashboard {

			public static final String ANALYSIS_ITEM_FOLDERS = "analysis-item-folders";
			public static final String GRAPH_LAYOUT = "??????";
			public static final String PROJECT_REPORT = "???????";
			
		}
		
		public static class FileStorageResources {

			public static final String ATTACHMENTS = "attachments";
			
		}
		
		public static class GeneralAndSiteResources {

			public static final String COPY = "copy";
			public static final String DOMAINS = "domains";
			
		}
	}

	public static class Properties {

		public static final String FABRICA_LOGO = "fabrica_logo";
		public static final String CLIENTE_LOGO = "cliente_logo";
		public static final String OUTPUT_DIR_BASE_EVIDENCES = "output_dir_base_evidences";
		public static final String CONFIG_PATH = "./utilitarios/properties/xpath.properties";
		public static final String CONFIG_PATH_MOBILE = "./utilitarios/properties/xpathMobile.properties";
		public static final String CONFIG_LINKS = "./utilitarios/properties/config.properties";
		public static final String CONFIG_GTEC = "./utilitarios/properties/gtec.properties";
		public static final String CONFIG_SERVICOS = "./utilitarios/properties/servicos.properties";
		public static final String CONFIG_ALM = "./utilitarios/properties/alm.properties";
		public static final String CONFIG_EMAIL = "./utilitarios/properties/email.properties";
		public static final String CONFIG_DB = "./utilitarios/properties/db.properties";
		public static final String CONFIG_MENSAGENS = "./utilitarios/properties/mensagens.properties";
		public static final String AUX_PATH = "aux_path";
		public static final String USERS_PATH = "users_path";
		public static final String FILES_PATH = "files_path";
		public static final String LAYOUTS_PATH = "layouts_path";
		public static final String TEMP = "temp";
		public static final String EVIDENCIA_PATH = "evidencia_path";
		public static final String EVIDENCIAS_CONSOLIDADAS = "evidenciasConsolidadas";
		public static final String APP_PATH = "app_path";
	}

	public static class ConfigProperties {

		public static final String URL_HOME_PAGE = "url_home_page";
		public static final String URL_CLM = "url_clm";
		public static final String LINK_MAILINATOR = "link_mailinator";
		public static final String AMBIENTE = "ambiente";
		public static final String SPRINT = "sprint";

		public static final String HOST = "host";
		public static final String PORT = "port";
		public static final String DOMAIN = "domain";
		public static final String PROJECT = "project";
		public static final String USERNAME = "username";
		public static final String PASSWORD = "password";
	}

	//=======XPATH.PROPERTIES===========

	public static class XpathProperties {

		public static final String TIMESTAMP = "dd-MM-yyyy";
		public static final String DATA_BARRA = "dd/MM/yyyy";
		public static final String HORA_MINUTO = "hh-mm";
		public static final String DATA_HORA="yyyyMMdd-HHmmss";
		public static final String OUTPUT_DIR_BASE = ".\\";
		public static final String OUTPUT_DIR_BASE_CONF = "./";
		public static final String TRACO = "-";
		public static final String UNDERLINE = "_";
		public static final String BARRA = "/";
		public static final String PONTO = ".";
		public static final String PNG_EXTENSION = "png";
		public static final String PNG = "png";
		public static final String PDF_EXTENSION = ".PDF";
		public static final String EXCEL_EXTENSION = ".xlsx";
		public static final String XML_EXTENSION = ".XML";
		public static final String CSV_EXTENSION = ".CSV";
		public static final String HEADERNAMECT = "NOME-CT";
		public static final String CT = "CT-";
		public static final String ARQUIVOMASSA = "massa.csv";
		public static final String ROTULO_EVIDENCIA_TESTE = "Evidncias de Teste";
		public static final String ROTULO_RESULTADO_ESPERADO = "Resultado Esperado";
		public static final String ROTULO_RESULTADO = "Resultado";
		public static final String ROTULO_ACAO = "Acao";
		public static final String ROTULO_STEP = "Step";
		public static final String ROTULO_CENARIO = "Cenario";
		public static final String ROTULO_DATA = "Data";
		public static final String ROTULO_FABRICA = "Nome da Fabrica aqui";
		public static final String ERRO = "ERRO";
		public static final String UPDATE = "UPDATE";
	}

	public static class ServicosProperties {

		public static final String CLIENT_ID = "client_id";
		public static final String URL_SERVICO_CREDENCIARCLIENTE = "url_servico_credenciarcliente";
		public static final String URL_SERVICO_CEPS = "url_servico_ceps";
		public static final String URL_SERVICO_CPFCNPJ = "url_servico_cpfcnpj";
		public static final String URL_SERVICO_CONTA_CORRENTE_EXISTE = "url_servico_conta_corrente_existe";
		public static final String URL_SERVICO_CONTA_CORRENTE_VALIDAR = "url_servico_conta_corrente_validar";
		public static final String URL_SERVICO_ENDERECO = "url_servico_endereco";
		public static final String URL_SERVICO_RAMO_ATIVIDADE = "url_servico_ramo_atividade";
		public static final String URL_SERVICO_VALIDA_MEI = null;
		public static final String URL_SERVICO_PROPOSTA = "url_servico_proposta";
		public static final String URL_SERVICO_PRODUTO = "url_servico_produtos";
		public static final String URL_SERVICO_VALIDA_EVENTO = null;
		public static final String URL_SERVICO_VALIDA_NUMERO_DE_EC = null;
		public static final String URL_SERVICO_VALIDA_CODIGO_ERRO = null;
		public static final String URL_SERVICO_VALIDA_CODIGO_DO_ESTABELECIMENTO = null;
		public static final String URL_SERVICO_PROPOSTA_RASCUNHO = "url_servico_proposta_rascunho";
		public static final String URL_SERVICO_PROPOSTA_CLIENTE = "url_servico_proposta_cliente";
		public static final String URL_SERVICO_VALIDA_MCC = "url_servico_valida_mcc";
		public static String URL_SERVICO_CONTA_CORRENTE_NAO_EXISTE = "url_servico_conta_corrente_nao_existe";
		public static final String URL_LISTA_BANCOS = "url_lista_bancos";

	}

	public static class Commands {

		public static final String ADB_PATH = "adb_path";
		public static final String EMULATOR_PATH = "emulator_path";
	}

	public static class EMAIL {
		
		public static class Credentials {
			
			public static final String EMAIL_FROM = "email";
			public static final String EMAIL_TO = "email_to";
			public static final String EMAIL_HOST = "email_host";
			public static final String EMAIL_PASS = "email_pass";
			public static final String EMAIL_PORT = "email_port";
			
		}	
		
	}

	public static class MIME {
		public static final String XML = "xml";
		public static final String PNG = "png";
	}

}