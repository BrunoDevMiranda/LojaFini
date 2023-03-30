package br.com.lojafini.application;

import br.com.lojafini.data.model.Cliente;
import br.com.lojafini.factory.connection.ClienteDao;

public class MainTest {
    public static void main(String[] args) {

        Cliente cliente = new Cliente(1, "Bruno", "123.359.963-55", "Bonsucesso", "1987/05/05");
        ClienteDao dao = new ClienteDao();

        dao.save(cliente);

    }
}
