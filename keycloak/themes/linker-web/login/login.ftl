<#import "template.ftl" as layout>
<@layout.registrationLayout displayInfo=social.displayInfo displayWide=(realm.password && social.providers??); section>
    <#if section = "form">
    <section class="p-auth__pic pink">
        <div class="p-auth__catch">
            <h1>研究チームと未来を共創</h1>
            <p>自社の課題解決の鍵となる魅力的な研究シーズを<br>探す、見つける、そして繋がる</p>
        </div>
        <img src="${url.resourcesPath}/img/illust_3.png">
    </section>

    <section class="p-auth__main">
        <div class="p-auth__main__inner">
          <div class="c-headline">
            <h2>Sign in</h2>
          </div>

          <div id="kc-social-providers" class="${properties.kcFormSocialAccountContentClass!} ${properties.kcFormSocialAccountClass!}">
              <ul>
                  <#list social.providers as p>
                    <li>
                        <#switch p.providerId>
                            <#case "facebook">
                                <#assign alias="fb"/> 
                                <#break>
                            <#case "google">
                                <#assign alias="gg"/> 
                                <#break>
                            <#case "twitter">
                                <#assign alias="tw"/> 
                                <#break>
                        </#switch>
                        <a href="${p.loginUrl}" class="p-auth__main__sns--${alias}">
                            <p class="p-auth__main__sns__ic"><img src="${url.resourcesPath}/img/ic_login_${alias}.svg"></p>
                            <p class="p-auth__main__sns__txt">${p.displayName}</p>
                        </a>
                    </li>
                  </#list>
              </ul>
          </div>

          <p class="p-auth__main__or"><span>or</span></p>

          <form action="${url.loginAction}" method="post" ref="form" @submit="submit">
            <ul class="c-form">
              <li class="c-form__item">
                <p class="c-form__item__ttl">メールアドレス</p>
                <div class="c-form__item__body">
                  <input type="email" class="c-inputtext" placeholder="sample@email.com" name="username" value="${(login.username!'')}">
                  <#--  <p v-if="!emailCheckFlg" class="c-form__error">エラーメッセージ</p>  -->
                </div>
              </li>
              <li class="c-form__item">
                <p class="c-form__item__ttl">パスワード</p>
                <div class="c-form__item__body">
                  <input type="password" class="c-inputtext" name="password" value="${(login.username!'')}" v-model="password">
                  <#--  <p v-if="!passwordCheckFlg" class="c-form__error">エラーメッセージ</p>  -->
                </div>
              </li>
            </ul>
            <div class="p-auth__main__btns">
              <button class="c-btn--smallBgBlue">Sign in</button>
              <a href="${url.loginResetCredentialsUrl}" class="l-textLink--purple">パスワードを忘れた方はこちら</a>
            </div>
          </form>
        </div>
    </section>
    </#if>

</@layout.registrationLayout>
