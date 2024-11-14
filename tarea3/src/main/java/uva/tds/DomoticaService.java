package uva.tds;

/**
 * Interfaz de una clase que representa un servicio externo de domótica
 * @author marcorr
 *
 */
public interface DomoticaService {
	
	/**
	 * Enciende las luces de una casa
	 * @param porcentajeIntensidad indica la intensidad de las luces en porcentaje entero [0,100]
	 * @throws IllegalStateException si las luces ya están encendidas
	 * @throws IllegalArgumentException si el porcentaje es menor que 0 o mayor que 100
	 */
	public void encenderLuces(int porcentajeIntensidad);
	
	/**
	 * Apaga las luces de una casa. La intensidad pasa a 0
	 * @throws IllegalStateException si las luces ya están apagadas
	 */
	public void apagarLuces();
	
	/**
	 * Modifica la disponibilidad del servicio
	 * @param available true para habilitar y false para deshabilitar
	 */
	public void setAvailable(boolean available);
	
	/**
	 * Indica si el servicio está disponible
	 * @return true si está disponible y false en caso contrario
	 */
	public boolean isAvailable();
	
	/**
	 * Indica si las luces están encendidas (true) o apagadas (false)
	 * @return El estado de las luces
	 */
	public boolean lucesEncencidas();

	/*
	 * Devuelve la intensidad de las luces. Si están apagadas, debe ser 0
	 */
	public int getIntensidad();
	
	

}
