ALTER TABLE execucoes DROP COLUMN encontrou_erro;
ALTER TABLE execucoes ADD COLUMN quantidade_processos_lidos INTEGER DEFAULT 0;