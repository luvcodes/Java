/*
 Aggregate function
 */
select max(invoice_total)
from sql_invoicing.invoices;

SELECT max(invoice_total) AS highest,
    min(invoice_total) as lowest,
    avg(invoice_total) as average
from sql_invoicing.invoices;

SELECT max(invoice_total) AS highest,
    min(invoice_total) as lowest,
    avg(invoice_total) as average,
    sum(invoice_total) as total,
    count(invoice_total) as number_of_invoices
from sql_invoicing.invoices;

SELECT max(invoice_total) AS highest,
    min(invoice_total) as lowest,
    avg(invoice_total) as average,
    sum(invoice_total) as total,
    count(payment_date) as count_of_payments
from sql_invoicing.invoices;

SELECT MAX(invoice_total) AS highest,
    MIN(invoice_total) AS lowest,
    AVG(invoice_total) AS average,
    SUM(invoice_total * 1.1) AS total,
    COUNT(distinct client_id) AS total_records
FROM sql_invoicing.invoices
WHERE invoice_date > '2019-07-01';

select 'First half of 2019' as date_range,
    sum(invoice_total) as total_sales,
    sum(payment_total) as total_payments,
    sum(invoice_total - payment_total) as what_we_expect
from sql_invoicing.invoices
where invoice_date between '2019-01-01' and '2019-06-30'
union
select 'Second half of 2019' as date_range,
    sum(invoice_total) as total_sales,
    sum(payment_total) as total_payments,
    sum(invoice_total - payment_total) as what_we_expect
from sql_invoicing.invoices
where invoice_date between '2019-07-01' and '2019-12-31'
union
select 'Total' as date_range,
    sum(invoice_total) as total_sales,
    sum(payment_total) as total_payments,
    sum(invoice_total - payment_total) as what_we_expect
from sql_invoicing.invoices
where invoice_date between '2019-01-01' and '2019-12-31';