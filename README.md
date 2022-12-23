# Четвертая лабораторная работа, Сервис - Ориентированная архитектура
Отчет в основном репозитории ITMO

## Ссылки
Реализуемая спецификация из первой работы: [Лабораторная работа №1](https://se.ifmo.ru/~s284731/SOA/)  
Клиентское приложение: [EgorMIt/SOA-Lab2-frontend](https://github.com/EgorMIt/SOA-Lab2-frontend)
## Вариант задания

На основе разработанной в рамках лабораторной работы #1 спецификации реализовать два веб-сервиса и использующее их API клиентское приложение.

Требования к реализации и развёртыванию сервисов:

* Первый ("вызываемый") веб-сервис должен быть реализован на фреймворке JAX-RS и развёрнут в окружении под управлением сервера приложений Payara.
* Второй веб-сервис должен быть реализован на фреймворке Spring MVC REST, развёрнут в окружении под управлением сервера приложений Jetty и вызывать REST API первого сервиса.
* Для обоих сервисов необходимо реализовать все функции, задокументированные в API, в строгом соответствии со спецификацией!
* Доступ к обоим сервисам должен быть реализован с по протоколу https с самоподписанным сертификатом сервера. Доступ к сервисам посредством http без шифрования должен быть запрещён.

Требования к клиентскому приложению:

* Клиентское приложение может быть написано на любом веб-фреймворке, который можно запустить на сервере helios.
* Приложение должно обеспечить полный набор возможностей, предоставляемых API обоих сервисов -- включая сортировку, фильтрацию и постраничный вывод элементов коллекции.
* Приложение должно преобразовывать передаваемые сервисами данные в человеко-читаемый вид -- параграф текста, таблицу и т.д.
* Клиентское приложение должно информировать пользователя об ошибках, возникающих на стороне сервисов, в частности, о том, что сервису были отправлены невалиданые данные.

Оба веб-сервиса и клиентское приложение должны быть развёрнуты на сервере helios.
