
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

public class DataHora implements Serializable {
    Date data;
    Time hora;

    public DataHora() {
        this.data = new Date();
        this.hora = new Time(1000);
    }
}
