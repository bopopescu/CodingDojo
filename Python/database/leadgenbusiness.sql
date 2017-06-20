-- 1. What query would you run to get the total revenue for March of 2012?
select * from billing;

select MONTHNAME(charged_datetime) as month, sum(amount) as revenue
from billing
where charged_datetime LIKE '2012-03%';

-- 2. What query would you run to get total revenue collected from the client with an id of 2?
select * from clients;
select client_id, sum(amount) as total_revenue
from billing 
where client_id = 2;

-- 3. What query would you run to get all the sites that client=10 owns?
select * from sites;

select domain_name as website, client_id
from sites
where client_id= 10;

-- 4. What query would you run to get total # of sites created per month per year for the client with an id of 1? What about for client=20?
select client_id, count(domain_name) as num_of_websites, MONTHNAME(created_datetime), YEAR(created_datetime)
from sites
where client_id = 1
group by sites.domain_name
order by YEAR(created_datetime) asc;

select client_id, count(domain_name) as num_of_websites, MONTHNAME(created_datetime), YEAR(created_datetime)
from sites
where client_id = 20
group by sites.domain_name;

-- 5. What query would you run to get the total # of leads generated for each of the sites between January 1, 2011 to February 15, 2011?

select domain_name as website, count(leads_id) as num_of_leads, DATE_FORMAT(leads.registered_datetime, '%b %d %Y') as date_generated
from sites
left join leads
on sites.site_id = leads.site_id
where registered_datetime between cast('2011-01-01' as DATE) and cast('2011-02-15' as date)
group by leads.leads_id;


-- 6. What query would you run to get a list of client names and the total # of leads we've generated for each of our clients between January 1, 2011 to December 31, 2011?
select concat(clients.first_name, " ", clients.last_name) as client_name, count(leads_id) as number_of_leads
from clients
left join sites
on sites.client_id = clients.client_id
left join leads
on sites.site_id = leads.site_id
where registered_datetime between cast('2011-01-01' as DATE) and cast('2011-12-31' as date)
group by sites.client_id;

-- 7. What query would you run to get a list of client names and the total # of leads we've generated for each client each month between months 1 - 6 of Year 2011?
select concat(clients.first_name, " ", clients.last_name) as client_name, count(leads_id) as number_of_leads, DATE_FORMAT(leads.registered_datetime, '%b') as month_generated
from clients
left join sites
on sites.client_id = clients.client_id
left join leads
on sites.site_id = leads.site_id
where leads.registered_datetime between cast('2011-01-01' as DATE) and cast('2011-06-30' as date)
group by leads.leads_id;
-- select * from leads;

-- 8. What query would you run to get a list of client names and the total # of leads we've generated for each of our clients' sites between January 1, 2011 to December 31, 2011? Order this query by client id.  Come up with a second query that shows all the clients, the site name(s), and the total number of leads generated from each site for all time.
select concat(clients.first_name, " ", clients.last_name) as client_name, domain_name as website, count(leads_id) as number_of_leads, DATE_FORMAT(leads.registered_datetime, '%b %d %Y') as date_generated
from clients
left join sites
on sites.client_id = clients.client_id
left join leads
on sites.site_id = leads.site_id
where leads.registered_datetime between cast('2011-01-01' as DATE) and cast('2011-12-31' as date)
group by leads.site_id
order by clients.client_id asc;
-- select * from leads;

select concat(clients.first_name, " ", clients.last_name) as client_name, domain_name as website, count(leads_id)
from clients
left join sites
on sites.client_id = clients.client_id
left join leads
on sites.site_id = leads.site_id
group by leads.site_id
order by clients.client_id asc;

-- 9. Write a single query that retrieves total revenue collected from each client for each month of the year. Order it by client id.
select concat(clients.first_name, " ", clients.last_name) as client_name, sum(amount) as total_revenue, MONTHNAME(charged_datetime) as month_charge, YEAR(charged_datetime) as year_charge
from billing
left join clients
on clients.client_id = billing.client_id
group by client_name, month(charged_datetime), year(charged_datetime) 
order by clients.client_id asc;

-- 10. Write a single query that retrieves all the sites that each client owns. Group the results so that each row shows a new client. It will become clearer when you add a new field called 'sites' that has all the sites that the client owns. (HINT: use GROUP_CONCAT)
select concat(clients.first_name, " ", clients.last_name) as client_name, group_concat(domain_name separator ' / ') as sites 
from clients
left join sites
on sites.client_id = clients.client_id
group by clients.client_id;

-- 


