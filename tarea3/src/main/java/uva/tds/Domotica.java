package uva.tds;

/**
 * Aplicación que permite controlar el encendido y apagado de las luces de una
 * casa utilizando un servicio externo para realizar las operaciones. Por
 * defecto,
 * las luces están apagadas.
 * 
 * @author marcorr
 *
 */
public class Domotica {

	private DomoticaService domService;

	/**
	 * Crea un gestor de domótica de una casa que se comunica con un servicio
	 * externo
	 * 
	 * @param domService El servicio de domotica
	 * @throws IllegalArgumentException si domService es nulo
	 */
	public Domotica(DomoticaService domService) {
		if (domService == null) {
			throw new IllegalArgumentException();
		}
		this.domService = domService;
	}

	/**
	 * Devuelve el servicio de domótica
	 * 
	 * @return El servicio de domótica
	 */
	public DomoticaService getDomoticaService() {
		return this.domService;
	}

	/**
	 * Inicializa el servicio de domótica habilitando dicho servicio
	 * 
	 * @throws IllegalStateException si domService es nulo
	 */
	public void init() {
		isNull(this.domService);
		this.domService.setAvailable(true);
	}

	/**
	 * Indica si el servicio está disponible
	 * 
	 * @return True si está disponible y False en caso contrario
	 * @throws IllegalStateException si domService es nulo
	 */
	public boolean isAvailable() {
		isNull(this.domService);
		return this.domService.isAvailable();
	}

	/**
	 * Enciende las luces de una casa usando el servicio
	 * DomoticaService
	 * 
	 * @param porcentajeIntensidad indica la intensidad de las luces en porcentaje
	 *                             decimal [0.0,100.0]
	 * @throws IllegalStateException    si domService es nulo
	 * @throws IllegalStateException    si domService no está habilitado
	 * @throws IllegalStateException    si las luces ya están encendidas
	 * @throws IllegalArgumentException si el porcentaje es menor que 0.0 o mayor
	 *                                  que 100.0
	 * 
	 * 
	 */
	public void encenderLuces(double intensidad) {
		isNull(this.domService);
		if (!isAvailable()) {
			throw new IllegalStateException();
		}
		try {
			int intensidadServicio = (int) intensidad;
			this.domService.encenderLuces(intensidadServicio);
		} catch (IllegalStateException e) {
			throw e;
		} catch (IllegalArgumentException e2) {
			throw e2;
		}

	}

	/**
	 * Apaga las luces de una casa usando el servicio. La intensidad pasa a 0
	 * DomoticaService
	 * 
	 * @throws IllegalStateException si domService es nulo
	 * @throws IllegalStateException si domService no está habilitado
	 * @throws IllegalStateException si las luces ya están apagadas
	 * 
	 */
	public void apagarLuces() {
		isNull(this.domService);
		if (!isAvailable()) {
			throw new IllegalStateException();
		}
		try {
			this.domService.apagarLuces();
		} catch (IllegalStateException e) {
			throw e;
		}
	}

	/**
	 * Indica si las luces están encendidas (true) o apagadas (false) utilizando el
	 * servicio DomoticaService
	 * 
	 * @return El estado de las luces
	 * @throws IllegalStateException si heatingService es nulo
	 * @throws IllegalStateException si heatingService no está disponible
	 */
	public boolean lucesEncencidas() {
		isNull(this.domService);
		if (!isAvailable()) {
			throw new IllegalStateException();
		}
		return this.domService.lucesEncencidas();
	}

	private void isNull(DomoticaService dom) {
		if (dom == null) {
			throw new IllegalArgumentException();
		}
	}

}
