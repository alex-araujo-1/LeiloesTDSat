/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leiloestdsat;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ProdutosDAO {

    private conectaDAO conexao;
    private Connection conn;

    public ProdutosDAO() {
        this.conexao = new conectaDAO();
        this.conn = this.conexao.connectDB();
    }
    
    

    public void cadastrarProduto(ProdutosDTO produto) {
//conn = new conectaDAO().connectDB();

        String sql = "INSERT INTO produtos(nome, valor, status) VALUES (?, ?, ?)";

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setInt(2, produto.getValor());
            stmt.setString(3, produto.getStatus());
            stmt.execute();

        } catch (Exception e) {
            System.out.println("Erro ao inserir produto: " + e.getMessage());
        }

    }
    
 
    
    public void venderProduto(ProdutosDTO proct) {

        String sql = ("UPDATE produtos SET status = ? where id = ?");

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, proct.getStatus());
            stmt.setInt(2, proct.getId());
            stmt.execute();

        } catch (Exception ex) {
            System.out.println("Erro ao encontrar produto: " + ex.getMessage());
        }
    }
    

    
    public List<ProdutosDTO> listarProdutos() {
        String sql = "SELECT * FROM produtos";

        try {
            
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            List<ProdutosDTO> listagem = new ArrayList<>();

            while (rs.next()) {
                ProdutosDTO produto = new ProdutosDTO();

                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setValor(rs.getInt("valor"));
                produto.setStatus(rs.getString("status"));

                listagem.add(produto);
            }
            return listagem;

        } catch (Exception e) {
            return null;
        }
    }
    
    
    
    public List<ProdutosDTO> listarProdutosVendidos() {

        String sql = "SELECT * FROM produtos WHERE status = 'Vendido' ";

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            List<ProdutosDTO> listaProdutos_V = new ArrayList<>();

            while (rs.next()) {
                ProdutosDTO produtoV = new ProdutosDTO();

                produtoV.setId(rs.getInt("id"));
                produtoV.setNome(rs.getString("nome"));
                produtoV.setValor(rs.getInt("valor"));
                produtoV.setStatus(rs.getString("status"));

                listaProdutos_V.add(produtoV);

            }

            return listaProdutos_V;

        } catch (Exception e) {
            return null;
        }

    }

}

    

