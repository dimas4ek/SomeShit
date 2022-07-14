<#import "parts/common.ftlh" as c>

<@c.page>
    <div class="form-row">
        <div class="form-group col md-6">
            <form method="get" action="/main" class="form-inline">
                <input type="text" name="filter" class="form-control" value="${filter?ifExists}" placeholder="Search by username">
                <button type="submit" class="btn btn-primary ml-2">Search</button>
            </form>
        </div>
    </div>
    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
        Add new message
    </a>
    <div class="collapse" id="collapseExample">
        <div class="form-group mt-3">
            <form method="post" enctype="multipart/form-data">
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <div class="form-group">
                    <input type="text" class="form-control" name="text" placeholder="type a message" />
                </div>
                <div class="form-group">
                    <div class="custom-file">
                        <input type="file" class="form-control" name="file" id="customFile">
                        <label class="custom-file-label" for="customFile">Choose file</label>
                    </div>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Add</button>
                </div>
            </form>
        </div>
    </div>
    <div class="card-columns">
        <#list messages as message>
            <div class="card my-3">
                <div class="card-footer text-muted">
                    ${message.authorName}: <i>${message.text}</i>
                </div>
                <#if message.filename??>
                    <img class="card-img-top" src="/img/${message.filename}">
                </#if>
            </div>
        <#else>No messages
        </#list>
    </div>
</@c.page>