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
            <div id="comandos">
                <a href="javascript:void(0)"
                   class="botao"
                   id="add">
                    Adicionar
                </a>
                <div>
                    <label for="busca">Busca</label>
                    <input type="search" name="busca" id="busca"
                           placeholder="Digite para buscar">
                </div>
            </div>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Registro</th>
                        <th>Especialidade</th>
                        <th>Unidade</th>
                        <th>Telefone</th>
                        <th>E-mail</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                    <tr>
                        <td class="fit">1</td>
                        <td>Maria Adelia Serravalle Bezerra</td>
                        <td>CRM/AC 377</td>
                        <td>Cardiologia</td>
                        <td>Unidade A</td>
                        <td>(68) 98205-4704</td>
                        <td>monique.nespoli@uol.com.br</td>
                        <td>
                            <a href="javascript:void(0)"
                               class="botao">Editar</a>
                            <a href="javascript:void(0)"
                               class="botao excluir">Excluir</a>
                        </td>
                    </tr>
                </tbody>
                <tfoot>
                    <tr>
                        <td colspan="8">Total de registros: 5</td>
                    </tr>
                </tfoot>
            </table>
        </main>
        <footer>
            <span>SGCM - Sistema de Gerenciamento de Clínica Médica</span>
            <span>Suporte técnico: (68) 5555-5555 | <a href="mailto:suporte.sgcm@ufac.br">suporte.sgcm@ufac.br</a></span>
        </footer>
    </body>
</html>