package returned_models;

/**
 *
 * @author gnuno
 */
public class RespuestaCredencialesCorrectas {
        public String resultadoFuncion;
        public int id_usuario;
        
        public RespuestaCredencialesCorrectas()
        {
            resultadoFuncion = "";
            id_usuario = 0;
        }
        
        public RespuestaCredencialesCorrectas(String resultadoFuncion, int id_usuario)
        {
            this.resultadoFuncion = resultadoFuncion;
            this.id_usuario = id_usuario;
        }
}
