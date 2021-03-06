#language: ru
Функционал: Вклады

  @all
  Сценарий: Первый сценарий

    * Переходим во Вклады

    * СНОВА переходим во Вклады

    * Выбираем валюту "Рубли"

    * Заполняются поля:
      | Сумма вклада           | 300000 |
      | Ежемесячное пополнение | 50000  |
      | На срок                | 9      |

    * Ставим галочку 'Ежемесячная капитализация'

    * Выполнена проверка значений:
      | Начислено %              | 18 056,35  |
      | Пополнение за 9 месяцев  | 400 000    |
      | К снятию через 9 месяцев | 718 056,35 |


  @all
  Сценарий: Второй сценарий

    * Переходим во Вклады

    * СНОВА переходим во Вклады

    * Выбираем валюту "Доллары США"

    * Заполняются поля:
      | Сумма вклада           | 500000 |
      | Ежемесячное пополнение | 5000   |
      | На срок                | 9      |

    * Ставим галочку 'Ежемесячная капитализация'

    * Выполнена проверка значений:
      | Начислено %              | 1 159,38   |
      | Пополнение за 9 месяцев  | 40 000     |
      | К снятию через 9 месяцев | 541 159,38 |
