<nav class="navbar-default navbar-static-side" role="navigation">
    <!-- sidebar-collapse -->
    <div class="sidebar-collapse">
        <!-- side-menu -->
        <ul class="nav" id="side-menu">
            <li>
                <!-- user image section-->
                <div class="user-section">
                    <div class="user-section-inner">
                        <asset:image src="user.jpg" alt="Image de Perfil"/>
                    </div>

                    <div class="user-info">
                        <div>${user.getNomeAbreviado()}</div>

                        <div class="user-text-online">
                            <span></span>&nbsp;${user.getTipoAcesso()}
                        </div>
                    </div>
                </div>
                <!--end user image section-->
            </li>
            <li class="selected">
                <a href="${createLink(controller: 'aluno', action: 'index')}"><i class="fa fa-dashboard fa-fw"></i>Dashboard</a>
            </li>
            <li>
                <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Atividades<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <g:each var="atividade" in="${atividades}">
                        <li>
                            <a href="${createLink(controller: 'atividade', action: 'show', id: atividade.id)}">${atividade.nome}</a>
                        </li>
                    </g:each>
                </ul>
                <!-- second-level-items -->
            </li>
            %{--<li>--}%
                %{--<a href="timeline.html"><i class="fa fa-flask fa-fw"></i>Timeline</a>--}%
            %{--</li>--}%
            %{--<li>--}%
                %{--<a href="tables.html"><i class="fa fa-table fa-fw"></i>Tables</a>--}%
            %{--</li>--}%
            %{--<li>--}%
                %{--<a href="forms.html"><i class="fa fa-edit fa-fw"></i>Forms</a>--}%
            %{--</li>--}%
            %{--<li>--}%
                %{--<a href="#"><i class="fa fa-wrench fa-fw"></i>UI Elements<span class="fa arrow"></span></a>--}%
                %{--<ul class="nav nav-second-level">--}%
                    %{--<li>--}%
                        %{--<a href="panels-wells.html">Panels and Wells</a>--}%
                    %{--</li>--}%
                    %{--<li>--}%
                        %{--<a href="buttons.html">Buttons</a>--}%
                    %{--</li>--}%
                    %{--<li>--}%
                        %{--<a href="notifications.html">Notifications</a>--}%
                    %{--</li>--}%
                    %{--<li>--}%
                        %{--<a href="typography.html">Typography</a>--}%
                    %{--</li>--}%
                    %{--<li>--}%
                        %{--<a href="grid.html">Grid</a>--}%
                    %{--</li>--}%
                %{--</ul>--}%
                %{--<!-- second-level-items -->--}%
            %{--</li>--}%
            %{--<li>--}%
                %{--<a href="#"><i class="fa fa-sitemap fa-fw"></i>Multi-Level Dropdown<span class="fa arrow"></span>--}%
                %{--</a>--}%
                %{--<ul class="nav nav-second-level">--}%
                    %{--<li>--}%
                        %{--<a href="#">Second Level Item</a>--}%
                    %{--</li>--}%
                    %{--<li>--}%
                        %{--<a href="#">Second Level Item</a>--}%
                    %{--</li>--}%
                    %{--<li>--}%
                        %{--<a href="#">Third Level <span class="fa arrow"></span></a>--}%
                        %{--<ul class="nav nav-third-level">--}%
                            %{--<li>--}%
                                %{--<a href="#">Third Level Item</a>--}%
                            %{--</li>--}%
                            %{--<li>--}%
                                %{--<a href="#">Third Level Item</a>--}%
                            %{--</li>--}%
                            %{--<li>--}%
                                %{--<a href="#">Third Level Item</a>--}%
                            %{--</li>--}%
                            %{--<li>--}%
                                %{--<a href="#">Third Level Item</a>--}%
                            %{--</li>--}%
                        %{--</ul>--}%
                        %{--<!-- third-level-items -->--}%
                    %{--</li>--}%
                %{--</ul>--}%
                %{--<!-- second-level-items -->--}%
            %{--</li>--}%
            %{--<li>--}%
                %{--<a href="#"><i class="fa fa-files-o fa-fw"></i>Sample Pages<span class="fa arrow"></span></a>--}%
                %{--<ul class="nav nav-second-level">--}%
                    %{--<li>--}%
                        %{--<a href="blank.html">Blank Page</a>--}%
                    %{--</li>--}%
                    %{--<li>--}%
                        %{--<a href="login.html">Login Page</a>--}%
                    %{--</li>--}%
                %{--</ul>--}%
                %{--<!-- second-level-items -->--}%
            %{--</li>--}%
        </ul>
        <!-- end side-menu -->
    </div>
    <!-- end sidebar-collapse -->
</nav>