<%@ page pageEncoding="UTF-8" %>

<%@ page import="java.util.List" %>
<%@ page import="br.ufac.sgcm.model.Profissional" %>

<jsp:useBean id="controller"
    class="br.ufac.sgcm.controller.ProfissionalController"
    scope="page" />

<%
    List<Profissional> registros = controller.processListRequest(request);
%>

<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, user-scalable=no">
        <title>SGCM - Profissionais</title>
        <link rel="stylesheet" href="./css/estilo.css">
        <link rel="stylesheet" href="./css/estilo-tema-azul.css" id="link-tema">
        <script src="./js/script.js" defer></script>
    </head>
    <body>
        <header>
            <div id="logo">
                <img src="imagens/logo_branco.png" alt="Logo SGCM">
                <span id="titulo">SGCM</span>
            </div>
            <div id="usuarioInfo">
                <span>Usuário: Administrador (admin)</span>
                <span>Papel: ADMIN</span>
                <select id="tema">
                    <option value="">Escolha um tema</option>
                    <option value="azul">Azul</option>
                    <option value="vermelho">Vermelho</option>
                    <option value="amarelo">Amarelo</option>
                </select>
                <a href="javascript:void(0)"
                   class="botao">Logout</a>
            </div>
        </header>
        <nav>
            <ul>
                <li><a href="agenda.html">Agenda</a></li>
                <li><a href="atendimento.html">Atendimento</a></li>
                <li><a href="pacientes.html">Pacientes</a></li>
                <li><a href="profissionais.html">Profissionais</a></li>
                <li><a href="convenios.html">Convênios</a></li>
                <li id="dropdown">
                    <a href="javascript:void(0)">
                        Configurações
                        <span>&#9660;</span>
                    </a>
                    <div id="dropdown_menu">
                        <a href="unidades.html">Unidades</a>
                        <a href="especialidades.html">Especialidades</a>
                        <a href="usuarios.html">Usuários</a>
                    </div>
                </li>
            </ul>
        </nav>
        <main>
            <form action="#">

                <div class="grid">

                <label for="nome">Nome</label>
                <input type="text" name="nome" id="nome" required>

                <label for="registroConselho">Registro</label>
                <input type="text" name="registroConselho" id="registroConselho" required>

                <label for="telefone">Telefone</label>
                <input type="text" name="telefone" id="telefone" required>

                <label for="email">E-mail</label>
                <input type="email" name="email" id="email" required>

                <label for="especialidade">Especialidade</label>
                <select name="especialidade" id="especialidade" required>
                    <option value=""></option>
                    <option value="1">Especialidade 1</option>
                    <option value="2">Especialidade 2</option>
                    <option value="3">Especialidade 3</option>
                </select>

                <label for="unidade">Unidade</label>
                <select name="unidade" id="unidade" required>
                    <option value=""></option>
                    <option value="1">Unidade 1</option>
                    <option value="2">Unidade 2</option>
                    <option value="3">Unidade 3</option>
                </select>

                </div>

                <input type="button" value="Cancelar">
                <input type="submit" value="Salvar">

            </form>
        </main>
        <footer>
            <span>SGCM - Sistema de Gerenciamento de Clínica Médica</span>
            <span>Suporte técnico: (68) 5555-5555 | <a href="mailto:suporte.sgcm@ufac.br">suporte.sgcm@ufac.br</a></span>
        </footer>
    </body>
</html>
