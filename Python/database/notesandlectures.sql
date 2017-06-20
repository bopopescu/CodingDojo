-- Joining tables
-- join
-- find all clients (first and last name) billing amounts and charged date
select * from clients;

select * from billing;

select clients.first_name, clients.last_name, billing.amount, billing.charged_datetime
from clients
join billing on clients.id = billing.clients_id;

-- list all the domain names and leads (first and last name) for each site
-- select sites.domain_name, leads.first_name, leads.last_name
-- from sites

select sites.domain_name, leads.first_name, leads.last_name 
from sites
join leads on sites.id = leads.sites_id;

-- join on multiple tables
-- get the names of the clients, their domain name and the first names of all the leads generated from those sites

select clients.first_name as clientFirstName, clients.last_name, sites.domain_name, leads.first_name
from clients
join sites on clients.id = sites.clients_id
join leads on sites.id = leads.sites_id;

-- left and right join
-- list all the clients and the sites each client has, even if the client hasn't landed a site yet
select clients.first_name, clients.last_name, sites.domain_name
from clients
left join sites on clients.id = sites.clients_id;

select clients.first_name, clients.last_name, SUM(billing.amount)
from clients
join billing on clients.id = billing.clients_id
group by clients.id;

-- GROUP CONCAT
-- LIST ALL THE DOMAIN NAMES ASSOCIATED WITH EACH CLIENT
select GROUP_CONCAT(' ', sites.domain_name) as domains, clients.first_name, clients.last_name
from clients
join sites on clients.id=sites.clients_id
group by clients.id;

-- count
-- find the total number of leads for each site
select count(leads.id), sites.domain_name
from sites
join leads on sites.id = leads.sites_id
group by sites.id;
 
 
