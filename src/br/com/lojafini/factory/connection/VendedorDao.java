package br.com.lojafini.factory.connection;


import br.com.lojafini.data.model.Vendedor;
import br.com.lojafini.factory.ConnectionFactory;
import br.com.lojafini.factory.DbException;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class VendedorDao {

    public void save(Vendedor vendedor) throws RuntimeException {
        String sql = "INSERT INTO tb_vendedor(nome, cpf,data_nasc,endereco) VALUES (?,?,?,?)";
        Connection connection = null;
        PreparedStatement pstm = null;
        try {
            //Create connection for DB
            connection = ConnectionFactory.getConnection();
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, vendedor.getNome());
            pstm.setString(2, vendedor.getCpf());
            pstm.setString(3, vendedor.getNascimento());
            pstm.setString(4, vendedor.getEndereco());


            int line = pstm.executeUpdate();
            if (line > 0) {
                out.println("Vendedor foi cadastrado com sucesso");
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

    public void update(Vendedor vendedor) throws DbException {
        String sql = "UPDATE tb_vendedor set nome = ?, cpf = ?, endereco = ?, data_nasc = ? " + "WHERE ID = ?";
        Connection connection = null;
        PreparedStatement pstm = null;
        try {
            connection = ConnectionFactory.getConnection();
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, vendedor.getNome());
            pstm.setString(2, vendedor.getCpf());
            pstm.setString(3, vendedor.getEndereco());
            pstm.setString(4, vendedor.getNascimento());
            pstm.setInt(5, vendedor.getId());
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

    public List<Vendedor> findVendedor() {
        String sql = "SELECT * FROM tb_vendedor ";
        List<Vendedor> vendedors = new ArrayList<>();
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        try {
            connection = ConnectionFactory.getConnection();
            pstm = connection.prepareStatement(sql);
            rset = pstm.executeQuery();
            while (rset.next()) {
                Vendedor vendedor = new Vendedor();
                vendedor.setId(rset.getInt(1));
                vendedor.setNome(rset.getString("nome"));
                vendedor.setCpf(rset.getString("cpf"));
                vendedor.setEndereco(rset.getString("endereco"));
                vendedor.setEndereco(rset.getString("data_nasc"));

                vendedors.add(vendedor);
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
            return vendedors;
        }
    }

    public void delete(int ID) {
        String sql = "DELETE FROM tb_vendedor WHERE ID = ?";
        Connection connection = null;
        PreparedStatement pstm = null;
        try {
            //Create connection for DB
            connection = ConnectionFactory.getConnection();
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1, ID);
            int line = pstm.executeUpdate();
            if (line > 0) {
                out.println("Vendedor foi deletada do banco de dados");
                JOptionPane.showMessageDialog(null, "Vendedor deletado com sucesso");
            } else {
                out.println("Vendedor não Cadastrado");
                JOptionPane.showMessageDialog(null, "Vendedor não encontrado", "Tente novamente", JOptionPane.ERROR_MESSAGE);
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

    public Vendedor findByCodigo(Integer ID) {
        String sql = "SELECT * FROM tb_vendedor where ID = ?";
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        try {
            connection = ConnectionFactory.getConnection();
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1, ID);
            rset = pstm.executeQuery();
            if (rset.next()) {
                Vendedor vendedor = new Vendedor();
                vendedor.setId(rset.getInt("ID"));
                vendedor.setNome(rset.getString("nome"));
                vendedor.setCpf(rset.getString("cpf"));
                vendedor.setNascimento(rset.getString("data_nasc"));
                vendedor.setEndereco(rset.getString("endereco"));
                if (ID != null) {
                    out.println("nome: " + vendedor.getNome() + ", CPF: " + vendedor.getCpf() + ", Endereço: " + vendedor.getEndereco()+ "Data de nascimento:"+ vendedor.getNascimento());
                }
            } else {
                out.println("Vendedor não encontrado");
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
