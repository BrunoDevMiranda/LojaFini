package br.com.lojafini.factory.connection;

import br.com.lojafini.data.model.Cliente;
import br.com.lojafini.factory.ConnectionFactory;
import br.com.lojafini.factory.DbException;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class ClienteDao {

    public void save(Cliente cliente) throws RuntimeException {
        String sql = "INSERT INTO tb_cliente(nome, cpf,data_nasc,endereco) VALUES (?,?,?,?)";
        Connection connection = null;
        PreparedStatement pstm = null;
        try {
            //Create connection for DB
            connection = ConnectionFactory.getConnection();
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, cliente.getNome());
            pstm.setString(2, cliente.getCpf());
            pstm.setString(3, cliente.getNascimento());
            pstm.setString(4, cliente.getEndereco());

            int line = pstm.executeUpdate();
            if (line > 0) {
                out.println("Cliente foi cadastrado com sucesso");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //close Connection
            try {
                ConnectionFactory.closePreparedStatement(pstm);
                ConnectionFactory.closeConnection(connection);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void update(Cliente cliente) throws DbException {
        String sql = "UPDATE tb_cliente set nome = ?, cpf = ?, endereco = ?, data_nasc = ? " + "WHERE ID = ?";
        Connection connection = null;
        PreparedStatement pstm = null;
        try {
            connection = ConnectionFactory.getConnection();
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, cliente.getNome());
            pstm.setString(2, cliente.getCpf());
            pstm.setString(3, cliente.getEndereco());
            pstm.setString(4, cliente.getNascimento());
            pstm.setInt(5, cliente.getId());
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //close Connection
            try {
                ConnectionFactory.closePreparedStatement(pstm);
                ConnectionFactory.closeConnection(connection);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<Cliente> findCliente() {
        String sql = "SELECT * FROM tb_cliente ";
        List<Cliente> clientes = new ArrayList<Cliente>();
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        try {
            connection = ConnectionFactory.getConnection();
            pstm = connection.prepareStatement(sql);
            rset = pstm.executeQuery();
            while (rset.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rset.getInt(1));
                cliente.setNome(rset.getString("nome"));
                cliente.setCpf(rset.getString("cpf"));
                cliente.setEndereco(rset.getString("endereco"));
                cliente.setNascimento(rset.getString("data_nasc"));

                clientes.add(cliente);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //close Connection
            try {
                ConnectionFactory.closePreparedStatement(pstm);
                ConnectionFactory.closeConnection(connection);
                ConnectionFactory.closeResultSet(rset);
            } catch (DbException e) {
                throw new RuntimeException(e);
            }
            return clientes;
        }
    }

    public void delete(int codigoCliente) {
        String sql = "DELETE FROM tb_cliente WHERE ID = ?";
        Connection connection = null;
        PreparedStatement pstm = null;
        try {
            //Create connection for DB
            connection = ConnectionFactory.getConnection();
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1, codigoCliente);
            int line = pstm.executeUpdate();
            if (line > 0) {
                out.println("Cliente foi deletada do banco de dados");
                JOptionPane.showMessageDialog(null, "Cliente deletado com sucesso");
            } else {
                out.println("Cliente não Cadastrado");
                JOptionPane.showMessageDialog(null, "Cliente não encontrado", "Tente novamente", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //close Connection
            try {
                ConnectionFactory.closePreparedStatement(pstm);
                ConnectionFactory.closeConnection(connection);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Cliente findByCodigo(Integer codigoCliente) {
        String sql = "SELECT * FROM tb_cliente where ID = ?";
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        try {
            connection = ConnectionFactory.getConnection();
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1, codigoCliente);
            rset = pstm.executeQuery();
            if (rset.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rset.getInt("ID"));
                cliente.setNome(rset.getString("nome"));
                cliente.setCpf(rset.getString("cpf"));
                cliente.setNascimento(rset.getString("data_nasc"));
                cliente.setEndereco(rset.getString("endereco"));
                if (codigoCliente != null) {
                    out.println("nome: " + cliente.getNome() + ", CPF: " + cliente.getCpf() + ", Endereço: " + cliente.getEndereco()+ ", Data de nascimento:"+ cliente.getNascimento());
                }
            } else {
                out.println("Cliente não encontrado");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //close Connection
            try {
                ConnectionFactory.closePreparedStatement(pstm);
                ConnectionFactory.closeConnection(connection);
                ConnectionFactory.closeResultSet(rset);
            } catch (DbException e) {
                throw new RuntimeException(e);
            }
            return null;
        }
    }

}
