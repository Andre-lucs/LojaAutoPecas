<%@ page import="java.util.List" %>
<%@ page import="br.com.lojaautopecas.model.*" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="customTag" uri="../WEB-INF/CustomTags.tld" %>

<%
    Venda venda = (Venda) request.getAttribute("venda");
    Cliente cliente = (Cliente) request.getAttribute("cliente");
    Funcionario funcionario = (Funcionario) request.getAttribute("funcionario");
    List<Servico> servicos = (List<Servico>) request.getAttribute("servicos");
    List<Peca> pecas = (List<Peca>) request.getAttribute("pecas");
    List<Servico> possibleNewServicos = (List<Servico>) request.getAttribute("servicosPossiveis");
    List<Peca> possibleNewPecas = (List<Peca>) request.getAttribute("pecasPossiveis");

%>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Detalhes Venda</title>
    <link rel="stylesheet" type="text/css" href="resources/css/styles.css"/>
</head>
<body>
    <customTag:header/>
    <div class="default-page">

    <div class="info">
        <div class="general-info">
            <div class="header-info">
                <h2>Informações Gerais: </h2>
                <button class="button delete-button" onclick="confirmAction('deletar esta venda', 'venda/delete?id=<%=venda.getId()%>')" class="delete-button">Excluir</button>
            </div>

            <div class="info-section">
                <span><strong>ID:</strong> <%=venda.getId()%></span>
                <span><strong>Data:</strong> <%=venda.getData()%></span>
                <span><strong>Valor total:</strong> <%=venda.getValor_Total()%></span>
            </div>
            <div class="client">
                <h3>Cliente:</h3>
                <span><strong>Nome:</strong> <%=cliente.getNome()%></span>
                <span><strong>Cpf:</strong> <%=cliente.getCpf()%></span>
            </div>
            <div class="functionary info-section">
                <h3>Funcionário:</h3>
                <span><strong>Nome:</strong> <%=funcionario.getNome()%></span>
                <span><strong>CPF:</strong><%=funcionario.getCpf()%></span>
            </div>
        </div>
         <div id="venda-servicos">
                <div>
                    <table>
                     <h2>Serviços:</h2>
                        <div class="table-top">

                            <div class="flexhor flexend">
                                <form class="hidden" action="venda/servico/add">
                                    <input type="hidden" name="vId" value="<%=venda.getId()%>"/>
                                    <label for="add-servico-venda">
                                        Adicionar um serviço para a venda:
                                        <select id="add-servico-venda" name="sId" required>
                                            <option value="">--Selecione o servico desejado--</option>
                                            <% for(Servico servico : possibleNewServicos) { %>
                                            <option value="<%=servico.getId()%>"><%=servico.getDescricao()+" | "+servico.getPreco()%></option>
                                            <% }%>
                                        </select>
                                    </label>
                                    <button type="submit" class="button">Adicionar</button>
                                </form>
                            </div>
                        </div>
                        <thead>
                        <th>ID</th>
                        <th>Descrição</th>
                        <th>Preco</th>
                        <th></th>
                        </thead>
                        <tbody>
                        <% for(Servico servico : servicos) { %>
                        <tr class="lastcolcenter">
                            <td><%=servico.getId()%></td>
                            <td><%=servico.getDescricao()%></td>
                            <td><%=servico.getPreco()%></td>
                            <td class="flexhor flexend">
                                <a class="button delete-button" href="venda/servico/delete?sid=<%=servico.getId()%>&vid=<%=venda.getId()%>">Deletar</a>
                            </td>
                        </tr>
                        <% }%>
                        </tbody>
                    </table>
                </div>
            </div>
    </div>

    <div id="venda-pecas">
        <div>
            <table>
                <div class="table-top">
                    <h2>Peças:</h2>
                    <div class="flexhor flexend">
                        <form class="hidden" action="venda/peca/add">
                            <input type="hidden" name="vId" value="<%=venda.getId()%>"/>
                            <label for="add-peca-venda">
                                Adicionar um peça para a venda:
                                <select id="add-peca-venda" name="pId" required>
                                    <option value="">--Selecione a peça desejada--</option>
                                    <% for(Peca peca : possibleNewPecas) { %>
                                    <option value="<%=peca.getId()%>"><%=peca.getNome()+" | "+peca.getPreco()%></option>
                                    <% }%>
                                </select>
                            </label>
                            <button type="submit" class="button">Adicionar</button>
                        </form>
                    </div>
                </div>
                <thead>
                <th>ID</th>
                <th>Nome</th>
                <th>Preco</th>
                <th></th>
                </thead>
                <tbody>
                <% for(Peca peca : pecas) { %>
                <tr>
                    <td><%=peca.getId()%></td>
                    <td><%=peca.getNome()%></td>
                    <td><%=peca.getPreco()%></td>
                    <td class="flexhor flexend">
                        <a class="button delete-button" href="venda/peca/delete?pid=<%=peca.getId()%>&vid=<%=venda.getId()%>">Deletar</a>
                    </td>
                </tr>
                <% }%>
                </tbody>
            </table>
        </div>
    </div>

    </div>
<script type="text/javascript" src="resources/scripts/redirect.js"></script>
</body>
</html>
