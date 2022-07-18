<#import "parts/common.ftlh" as c>

<@c.page>
    <h5>${username}</h5>
    ${message?ifExists}
    <form method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div class="form-group row">
            <label class="col-sm-1 col-form-label">Password: </label>
            <div class="col-sm-3">
                <input type="password" name="password" class="form-control" placeholder="Password" />
            </div>
        </div>
            <div class="form-group row">
                <label class="col-sm-1 col-form-label">Email: </label>
                <div class="col-sm-3">
                    <input type="email" name="email" class="form-control" placeholder="some@some.com" value="${email!''}"/>
                </div>
            </div>
        <button type="submit" class="btn btn-primary">Save</button>
    </form>
</@c.page>