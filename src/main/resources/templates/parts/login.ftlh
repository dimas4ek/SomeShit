<#macro login path isRegisterForm>
    <form action="${path}" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div class="form-group row">
            <label class="col-sm-1 col-form-label">Username: </label>
            <div class="col-sm-3">
                <input type="text" name="username" class="form-control" placeholder="Username" />
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-1 col-form-label">Password: </label>
            <div class="col-sm-3">
                <input type="password" name="password" class="form-control" placeholder="Password" />
            </div>
        </div>
        <button type="submit" class="btn btn-primary">
            <#if isRegisterForm>Sign up<#else>Sign in</#if>
        </button>
        <#if !isRegisterForm>
            <br>
            Click <a href="/registration">here</a> to sign up
        </#if>
    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit" class="btn btn-primary">Sign out</button>
    </form>
</#macro>